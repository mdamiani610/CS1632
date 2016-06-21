import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class WebTestingTest {

	static WebDriver driver = new HtmlUnitDriver();
	
	
	
	// Start at the home page for Mr. Laboon's hoodpopper website for each test
	@Before
	public void setUp() throws Exception {
		driver.get("http://lit-bayou-7912.herokuapp.com/");
	}
	
	/**
	 * As a user of hoodpopper,
	 * I would like to see the results from tokenizing the code I enter,
	 * So that I can learn more about tokenization in Ruby
	 * @author Matthew Damiani
	 *
	 */
	
	// Given that I am on the main page of hoodpopper
	// When I enter valid code into the textbox and press tokenize
	// Then I am redirected to the tokenization page
	@Test
	public void testShowsFunctionalTokenzation() {
		
		// Simply check that the webpage offers the ability to tokenize code entered in the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("a = 0");
		driver.findElement(By.name("commit")).click();
		header = driver.findElement(By.cssSelector("h1"));
		String x = header.getText();
		assertTrue(x.contains("Tokenize")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I enter multiple lines of valid code into the textbox and press tokenize
	// Then I am shown the results of the tokenized code containing newlines
	@Test
	public void testNewLineRecognition() {
			
		// Check that the tokenize operation successfully recognizes that an identifier has been typed into the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("a\nb\nc");
		driver.findElement(By.name("commit")).click();
		header = driver.findElement(By.cssSelector("code"));
		String x = header.getText();
		assertTrue(x.contains(":on_nl")); 
			
	}
	
	// Given that I am on the main page of hoodpopper
	// When I enter valid code with identifiers into the textbox and press tokenize
	// Then I see the results from the tokenization of the code containing identifiers
	@Test
	public void testIdentifierRecognition() {
		
		// Check that the tokenize operation successfully recognizes that an identifier has been typed into the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("a\nb");
		driver.findElement(By.name("commit")).click();
		header = driver.findElement(By.cssSelector("code"));
		String x = header.getText();
		assertTrue(x.contains(":on_ident")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
		// When I enter valid code with identifiers into the textbox and press tokenize
		// Then I see the results from the tokenization of the code containing identifiers
		@Test
		public void testOperationRecognition() {
			
			// Check that the tokenize operation successfully recognizes that an identifier has been typed into the textbox
			WebElement header = driver.findElement(By.id("code_code"));
			header.sendKeys("a=1\nb=a+a+a");
			driver.findElement(By.name("commit")).click();
			header = driver.findElement(By.cssSelector("code"));
			String x = header.getText();
			assertTrue(x.contains(":on_op")); 
			
		}
	
	// Given that I am on the main page of hoodpopper
	// When I press tokenize without entering anything into the textbox
	// Then I should still be brought to the tokenization page without the compilation visualizer crashing
	@Test
	public void testNoInputNoProblem1() {
		
		// Check that the tokenize operation still works even when there is no code typed into the textbox
		driver.findElement(By.name("commit")).click();
		WebElement header = driver.findElement(By.cssSelector("h1"));
		String x = header.getText();
		assertTrue(x.contains("Tokenize Operation")); 
		
	}
	
	/**
	 * As a user of hoodpopper,
	 * I would like to see the results from parsing the code I enter,
	 * So that I can learn more about parsing in Ruby
	 * @author Matthew Damiani
	 *
	 */
	
	// Given that I am on the main page of hoodpopper
	// When I enter valid code into the textbox and press parse
	// Then I am redirected to the parsing page
	@Test
	public void testShowsFunctionalParse() {
		
		// Simply check that the webpage offers the ability to parse code entered in the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("c = 0");
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		header = driver.findElement(By.cssSelector("h1"));
		String x = header.getText();
		assertTrue(x.contains("Parse")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I enter valid code containing variables into the textbox and press parse
	// Then I see the results from the parsing of the code
	@Test
	public void testVariableRecognition() {
		
		// Check that the parse operation successfully recognizes that variables (identifiers) have been typed into the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("d=0\ne=0");
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		header = driver.findElement(By.cssSelector("code"));
		String x = header.getText();
		assertTrue(x.contains(":@ident, \"d\"")&&x.contains(":@ident, \"e\"")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I press parse without entering anything into the textbox
	// Then I should still be brought to the parsing page without the compilation visualizer crashing
	@Test
	public void testNoInputNoProblem2() {
		
		// Check that the parse operation still works even when there is no code typed into the textbox
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		WebElement header = driver.findElement(By.cssSelector("h1"));
		String x = header.getText();
		assertTrue(x.contains("Parse Operation")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I enter a string, append another string to it and press parse
	// Then I see the two strings combined
	@Test
	public void testAppendStrings2() {
					
		// Check that the parserer recognizes 2 strings being appended together
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("string1=\"The best professor is \"\nputs string1+\"Mr Laboon\"");
		driver.findElement(By.xpath("(//input[@name='commit'])[2]")).click();
		header = driver.findElement(By.cssSelector("code"));
		String x = header.getText();
		assertTrue(x.contains("puts")); 
					
	}
	
	/**
	 * As a user of hoodpopper,
	 * I would like to see the results from parsing the code I enter,
	 * So that I can learn more about parsing in Ruby
	 * @author Matthew Damiani
	 *
	 */
	
	// Given that I am on the main page of hoodpopper
	// When I enter valid code into the textbox and press compile
	// Then I am redirected to the compiling page
	@Test
	public void testShowsFunctionalCompile() {
		
		// Simply check that the webpage offers the ability to compile code entered in the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("c = 0");
		driver.findElement(By.xpath("(//input[@name='commit'])[3]")).click();
		header = driver.findElement(By.cssSelector("h1"));
		String x = header.getText();
		assertTrue(x.contains("Compile")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I enter valid code with additon and subtraction into the textbox and press compile
	// Then I see the results showing addition and subtraction from compiling of the code
	@Test
	public void testAdditionSubtractionRecognition() {
		
		// Check that the parse operation successfully recognizes that variables (identifiers) have been typed into the textbox
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("x=1\ny=1+1\ny=y-x");
		driver.findElement(By.xpath("(//input[@name='commit'])[3]")).click();
		header = driver.findElement(By.cssSelector("code"));
		String x = header.getText();
		assertTrue(x.contains("opt_plus")&&x.contains("opt_minus")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I press parse without entering anything into the textbox
	// Then I should still be brought to the parsing page without the compilation visualizer crashing
	@Test
	public void testNoInputNoProblem3() {
		
		// Check that the parse operation still works even when there is no code typed into the textbox
		driver.findElement(By.xpath("(//input[@name='commit'])[3]")).click();
		WebElement header = driver.findElement(By.cssSelector("h1"));
		String x = header.getText();
		assertTrue(x.contains("Compile Operation")); 
		
	}
	
	// Given that I am on the main page of hoodpopper
	// When I enter a string, append another string to it and press compile
	// Then I see the two strings combined
	@Test
	public void testAppendStrings() {
				
		// Check that the compiler recognizes 2 strings being appended together
		WebElement header = driver.findElement(By.id("code_code"));
		header.sendKeys("string1=\"The best professor is \"\nputs string1+\"Mr Laboon\"");
		driver.findElement(By.xpath("(//input[@name='commit'])[3]")).click();
		header = driver.findElement(By.cssSelector("code"));
		String x = header.getText();
		assertTrue(x.contains("putstring")); 
				
	}

}
