package almosaferPart2;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSection extends TestData {

	// Method to select the hotel tab and search for a city
	public void hotelTabAndSearchCitiesTest() {
		// Navigate to the hotel search page
		driver.get(url2);

		// Click on the hotel tab to access hotel search options
		driver.findElement(By.id("uncontrolled-tab-example-tab-hotels")).click();

		// Array of possible cities to search for
		String[] areas = { "amman", "dubai", "jeddah", "muscat" };
		// Select a random city from the array
		int area = random.nextInt(areas.length);
		// Enter the selected city into the search input field
		driver.findElement(By.xpath("//input[@data-testid='AutoCompleteInput']")).sendKeys(areas[area]);
	}

	// Method to select the number of visitors from the dropdown
	public void vistorNumberTest() {
		// Locate the visitor number dropdown
		WebElement vistorNumber = driver
				.findElement(By.xpath("//select[@data-testid='HotelSearchBox__ReservationSelect_Select']"));
		// Create a Select object to interact with the dropdown
		Select mySelect = new Select(vistorNumber);
		// Select the option at index 1
		mySelect.selectByIndex(1);
	}

	// Method to set the check-in and check-out dates to February of a specific year
	public void checkinDateTest() {
		// Locate and click the check-in date button
		WebElement checkInButton = driver.findElement(By.id("js-hotelsSearchBoxDatePickerCheckInDate"));
		checkInButton.click();

		// Desired check-in month
		String checkInMonth = "February";
		while (true) {
			// Find the current month displayed in the calendar
			WebElement month = driver
					.findElement(By.xpath("//span[contains(@class, 'sc-5uo3xu-8') and contains(@class, 'iiBHpd')]"));
			String month2 = month.getText();

			// Check if the current month matches the desired check-in month
			if (month2.equals(checkInMonth)) {
				// Select the first day and the last day of February
				driver.findElement(By.xpath("//span[@data-testid='HotelsSearchCalendar__2025-02-01']")).click();
				driver.findElement(By.xpath("//span[@data-testid='HotelsSearchCalendar__2025-02-28']")).click();
				break;
			} else {
				// If not, go to the next month
				driver.findElement(By.xpath("//div[@data-testid='HotelsSearchCalendar__NextMonthButton']")).click();
			}
		}

		// Click the search button to perform the search
		driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']")).click();
	}

	// Method to ensure the hotel search results page is fully loaded
	public void HotelPageISFullyLoadedTest() {
		// Initialize WebDriverWait to wait for elements to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		// Wait until the results count element is present
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[@data-testid='HotelSearchResult__resultsFoundCount']")));
		// Locate the first result element
		WebElement firstResult = driver
				.findElement(By.xpath("//span[@data-testid='HotelSearchResult__Hotel0__TitleLabel']"));

		// Get the text of the first result and print it
		String firstResultAsString = firstResult.getText();
		System.out.println(firstResultAsString);
	}
}
