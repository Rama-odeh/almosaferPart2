package almosaferPart2;

import org.testng.annotations.Test;

public class myTestCases extends TestData {

	// Instance of the CrownRoseHotelPage class
	CrownRoseHotelPage crownRoseHotel = new CrownRoseHotelPage();

	// Instance of the HotelSection class
	HotelSection hotelSection = new HotelSection();

	/**
	 * Test case to navigate to the Crown Rose Hotel page and print all feedback
	 * (e.g., Excellent, Good) found on the page.
	 */
	@Test(priority = 1)
	public void printTheFeedBack() {
		crownRoseHotel.printTheFeedBackTest();
	}

	/**
	 * Test case to navigate to the hotel tab section and perform a search for one
	 * of the specified cities (Amman, Dubai, Jeddah, Muscat) in the search area.
	 */
	@Test(priority = 2)
	public void hotelTabAndSearchCities() {
		hotelSection.hotelTabAndSearchCitiesTest();
	}

	/**
	 * Test case to verify the visitor number functionality on the Hotel Section
	 * page.
	 */
	@Test(priority = 3)
	public void vistorNumber() {
		hotelSection.vistorNumberTest();
	}

	/**
	 * Test case to set the check-in date to the beginning of February and the
	 * check-out date to the end of February.
	 */
	@Test(priority = 4)
	public void checkinDate() {
		hotelSection.checkinDateTest();
	}

	/**
	 * Test case to print to the console the first result found after performing a
	 * search for hotels.
	 */
	@Test(priority = 5)
	public void HotelPageISFullyLoaded() {
		hotelSection.HotelPageISFullyLoadedTest();
	}
}
