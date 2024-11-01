package org.test.pages;

import org.example.elements.ListElement;
import org.example.elements.Element;
import org.openqa.selenium.By;

public class PIMPage {
    // Phần tử cho thông tin nhân viên
    Element txtEmployeeName = new Element(By.xpath("//div[.= 'Employee Name']//following-sibling::div/div/input"));
    Element txtEmployeeId = new Element(By.xpath("//div[.= 'Employee Id']//following-sibling::div/div/input"));
    Element sltEmploymentStatus = new Element(By.xpath("//div[.= 'Employment Status']//following-sibling::div/div"));
    Element sltInclude = new Element(By.xpath("//div[.= 'Include']//following-sibling::div/div"));
    Element sltJobTitle = new Element(By.xpath("//div[.= 'Job Title']//following-sibling::div/div"));
    ListElement listbox = new ListElement(By.xpath("//div[@role='listbox']//div//span"));
    Element btnSearch = new Element(By.xpath("//button[@type='submit']"));
    Element editIcon = new Element(By.xpath("//i[contains(@class,'pencil')]"));
    ListElement tablist = new ListElement(By.xpath("//div[@role='tablist']//div"));

    // Phần tử cho thông tin cá nhân
    Element txtFirstName = new Element(By.xpath("//div[.='First Name']/following-sibling::div/input"));
    Element txtLastName = new Element(By.xpath("//div[.='Last Name']/following-sibling::div/input"));
    Element txtOtherId = new Element(By.xpath("//div[.='Other Id']/following-sibling::div/input"));
    Element sltNationality = new Element(By.xpath("//div[.='Nationality']//following-sibling::div/div"));

    // Phần tử cho thông tin liên lạc
    Element txtStreet1 = new Element(By.xpath("//div[.='Street 1']/following-sibling::div/input"));
    Element txtStreet2 = new Element(By.xpath("//div[.='Street 2']/following-sibling::div/input"));
    Element txtCity = new Element(By.xpath("//div[.='City']/following-sibling::div/input"));
    Element txtState = new Element(By.xpath("//div[.='State/Province']/following-sibling::div/input"));
    Element txtZipCode = new Element(By.xpath("//div[.='Zip/Postal Code']/following-sibling::div/input"));
    Element sltCountry = new Element(By.xpath("//div[.='Country']//following-sibling::div/div"));
    Element loading = new Element(By.xpath("//div[contains(@class,'oxd-loading-spinner-container')]"));
    Element btnSave = new Element(By.xpath("//button[@type='submit']"));
    Element toastMessage = new Element(By.xpath("//p[contains(@class,'oxd-text--toast-message')]"));

    public PIMPage() {
    }

    // Nhập thông tin nhân viên
    public void inputEmployeeName(String employeeName) {
        txtEmployeeName.waitVisibility().sendKeys(employeeName);
    }

    public void inputEmployeeId(String employeeId) {
        txtEmployeeId.waitVisibility().sendKeys(employeeId);
    }

    public void selectEmploymentStatus(String employmentStatus) {
        sltEmploymentStatus.waitVisibility().click();
        listbox.waitVisibility().clickElementWithText(employmentStatus);
    }

    public void selectInclude(String include) {
        sltInclude.waitVisibility().click();
        listbox.waitVisibility().clickElementWithText(include);
    }

    public void selectJobTitle(String jobTitle) {
        sltJobTitle.waitVisibility().click();
        listbox.waitVisibility().clickElementWithText(jobTitle);
    }

    public void clickSearchButton() {
        btnSearch.waitVisibility().click();
    }

    public void clickEditIcon() {
        editIcon.waitVisibility().click();
    }

    public void selectTab(String tabmenu) {
        tablist.waitVisibility().clickElementWithText(tabmenu);
        loading.waitInvisibility();
    }

    // Cập nhật thông tin cá nhân
    public void updatePersonalDetails(String firstName, String lastName, String otherId, String nationality) {
        txtFirstName.waitVisibility().click();  // Chờ phần tử có thể thấy
        txtFirstName.clear();  // Xóa trước khi nhập
        txtFirstName.sendKeys(firstName);

        txtLastName.waitVisibility().click();
        txtLastName.clear();
        txtLastName.sendKeys(lastName);

        txtOtherId.waitVisibility().click();
        txtOtherId.clear();
        txtOtherId.sendKeys(otherId);

        sltNationality.waitClickable().click(); // Chọn quốc tịch từ danh sách nếu cần
        // Thêm mã để chọn quốc tịch cụ thể nếu cần
        clickSaveBtn();
    }


    // Cập nhật thông tin liên lạc
    public void updateContactInformation(String street1, String street2, String city, String state, String zipCode, String country) {
        txtStreet1.waitClickable().click().clearValueScript().sendKeys(street1);
        txtStreet2.waitClickable().click().clearValueScript().sendKeys(street2);
        txtCity.waitClickable().click().clearValueScript().sendKeys(city);
        txtState.waitClickable().click().clearValueScript().sendKeys(state);
        txtZipCode.waitClickable().click().clearValueScript().sendKeys(zipCode);
        sltCountry.waitClickable().click(); // Giả sử có một danh sách xổ xuống cho quốc gia
        // Cần thêm chi tiết để chọn quốc gia cụ thể nếu cần
        clickSaveBtn();
    }

    public void clickSaveBtn() {
        btnSave.waitVisibility().click();
    }

    public String getToastMessage() {
        return toastMessage.waitVisibility().getText();
    }
}
