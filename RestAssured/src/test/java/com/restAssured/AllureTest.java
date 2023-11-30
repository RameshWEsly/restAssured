package com.restAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;

public class AllureTest {

	//@Description("Simple allure test")
	@Test
	@Description("allure descriptionfor test")
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
	public void test1() {
		System.out.println("allure test");
		Assert.fail();
	}
	
}
