package sabreacademy.scrum;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

public class PBTest {
	PBList pbList = new PBList();

	@Test
	public void pbiShouldHaveName() throws Exception {
		PBI pbi = new PBI("Nazwa");
		assertThat(pbi.getName(), is(not(equalTo(""))));
		assertThat(pbi.getName(), is(notNullValue()));
	}
	
	@Test
	public void pbiShoulHaveEstimateField() throws Exception {
		PBI pbi = new PBI("Nazwa", "XL");
		assertThat(pbi.getEstimate(), is(notNullValue()));
	}
	
	@Test
	public void estimateCanBeEmpty() throws Exception {
		PBI pbi = new PBI("Nazwa");
		assertThat(pbi.getEstimate(), is(notNullValue()));
	}
	
	@Test
	public void pbiCanBeAddedAtTheEnd() throws Exception {
		// given
		PBI pbi = new PBI("Nazwa", "XL");
		// when
		pbList.addElementAtTheEnd(pbi);
		// then
		assertThat(pbList.getLastPBI(), is(equalTo(pbi)));
	}

	@Test
	public void pbiCanBeAddedInCertainPlace() throws Exception {
		// given
		pbList.addElementAtTheEnd(new PBI("Pierwszy", "XL"));
		pbList.addElementAtTheEnd(new PBI("Ostatni", "XL"));
		PBI pbi = new PBI("Srodkowy", "XL");
		
		// when
		pbList.addAtCertainPosition(pbi, 1);
		
		// then
		assertThat(pbList.getPBI(1), is(equalTo(pbi)));
	}
	
	@Test
	public void pbiHasUniqueOrder() throws Exception {
		// given
		PBI[] a = new PBI[] {new PBI("1"), new PBI("2"), new PBI("1")};		
		pbList.addAtCertainPosition(a[0], 0);
		pbList.addAtCertainPosition(a[1], 0);
		pbList.addAtCertainPosition(a[2], 0);

		// then
		assertThat(pbList.getPBIOrder(a[0]), is(not(equalTo(pbList.getPBIOrder(a[1])))));
		assertThat(pbList.getPBIOrder(a[1]), is(not(equalTo(pbList.getPBIOrder(a[2])))));
		assertThat(pbList.getPBIOrder(a[2]), is(not(equalTo(pbList.getPBIOrder(a[0])))));		
	}
}
