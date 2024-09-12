package almosaferPart2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrownRoseHotelPage extends TestData {

	// Method to print all unique feedback reviews
	public void printTheFeedBackTest() {

		// Initialize WebDriverWait to handle dynamic content
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// Click on the initial popup button to dismiss it
		driver.findElement(By.id("cta__button__popup")).click();

		// Click on the button to view reviews based on exclusive ratings
		WebElement ratingButton = driver.findElement(By
				.xpath("//div[contains(@class, 'MuiTypography-root') and contains(text(),'بناءً على تقييمات حصرية')]"));
		ratingButton.click();

		// List to store all unique loaded reviews
		List<String> allReviews = new ArrayList<>();
		boolean moreReviewsAvailable = true; // Flag to check if more reviews are available

		// Loop to keep loading more reviews until none are available
		while (moreReviewsAvailable) {
			// Retrieve the list of reviews on the current page
			List<WebElement> elements = driver.findElements(By.xpath(
					"//div[contains(@data-testid, 'hotel_details_reviews_modal_review_card_body_headline_test_id')]"));

			// Print and store all unique reviews
			for (WebElement element : elements) {
				String text = element.getText();
				if (!allReviews.contains(text)) { // Check if the review is already in the list
					allReviews.add(text); // Add the review to the list
					System.out.println(text); // Print the review text
				}
			}

			// Check if the "Load More" button is visible and clickable
			try {
//				WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
//						By.cssSelector(".__ds__comp.undefined.MuiBox-root.muirtl-1y3t1eg #mui-15")));
				
				WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.cssSelector(".__ds__comp.undefined.MuiBox-root.muirtl-1y3t1eg")));
				button.click(); // Click the button to load more reviews
				Thread.sleep(3000); // Wait for new reviews to load
			} catch (Exception e) {
				// If the button is not found or an error occurs, stop the loop
				moreReviewsAvailable = false;
			}
		}
	}
}
