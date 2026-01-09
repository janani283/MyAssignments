import test, { expect } from '@playwright/test'

test("PVR Cinemas",async({page,context})=>{

    await page.goto("https://www.pvrcinemas.com/")

    await page.getByRole('heading',{name:"Chennai"}).click()

      
   await page.locator("//span[text()='Cinema']").click()

   await page.locator("//span[text()='Select Cinema']").click()

   await page.locator("//span[contains(text(),'INOX National')]").click()

   //await page.locator("//span[text()='Select Date']").click()

   await page.locator("//span[contains(text(),'Today')]").click()

   await page.locator("//span[text()='PRABHAS S THE RAJASAAB']").nth(1).click()

   //await page.locator("(//ul[@class='p-dropdown-items']//span)[2]").click()

   await page.locator("//span[text()='03:10 PM']").click()

   await page.getByLabel("Submit").click()

   await page.locator("//button[text()='Accept']").click()

   await page.locator("//span[@id='SL.SILVER|C:10']").click()

    const seatno=await page.locator("//div[@class='seat-number']").innerText()
    console.log("The seat number is: "+seatno)

    const totalAmount=await page.locator("//div[@class='grand-prices']").innerText()
    console.log("The totalAmount is: "+totalAmount)

    const Title=await page.title()
    console.log("The last window title is: "+Title)

    const expTitle="PVR Cinemas"
     await expect.soft(Title).toEqual(expTitle)
    console.log("The page title is verified!!!")

    await page.locator(" //button[text()='Proceed']").click()
   
    await page.waitForTimeout(3000)
   

})
