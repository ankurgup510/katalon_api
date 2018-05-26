import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.remote.server.handler.SendKeys as SendKeys
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.ExcelData as ExcelData
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.helper.screenshot.WebUIScreenCaptor as WebUIScreenCaptor
import org.sikuli.script.Key as Key


ExcelData data = findTestData('API tests User registration/User_registration')
for (def index : (1..data.getRowNumbers())) {

WebUI.openBrowser('https://app-test.earthsquad.global/api/swagger/')

WebUI.delay(5)

WebUI.click(findTestObject('Registration/Registration_auth'))

WebUI.delay(5)

WebUI.click(findTestObject('Registration/Try_out'))

WebUI.delay(5)

WebUI.waitForElementPresent(findTestObject('Registration/Body'), 50)

WebUI.clearText(findTestObject('Registration/Body'))

WebUI.delay(1)

String username =findTestData('API tests User registration/User_registration').getValue('API-Username', index)
String email =findTestData('API tests User registration/User_registration').getValue('API-Username', index)
String password1 =findTestData('API tests User registration/User_registration').getValue('API-PWD1', index)
String password2 =findTestData('API tests User registration/User_registration').getValue('API-PWD2', index)

WebUI.sendKeys(findTestObject('Registration/Body'), '{"username":"'+username+'","email":"'+email+'","password1":"'+password1+'","password2":"'+password2+'"}')

WebUI.click(findTestObject('Registration/Execute'))
WebUI.delay(15)
WebUI.closeBrowser()
}
