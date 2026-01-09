import test, { expect } from '@playwright/test'

test("Decathlon",async({page,context})=>{

    //step2&3 navidating to url and verifying page title
    await page.goto("https://www.decathlon.in/")
    const Title=await page.title()
    console.log("The landing page title is: "+Title)
    const expTitle="Buy Sporting Goods, Sportswear and Equipments | Download App"
     await expect.soft(Title).toEqual(expTitle)
    console.log("The Lnading page title is verified!!!")

    //step4&5 clicking on search field ans checking its enabled
   await page.locator("//span[text()='Search for  ']").first().click()
   await expect(page.getByPlaceholder("Search For 60+ Sports and 6000+ Products")).toBeEnabled()
    const searchField = await page.getByPlaceholder("Search For 60+ Sports and 6000+ Products")
       

    //step6&7
    searchField.fill("shoes")
    searchField.press("Enter")
    await page.waitForTimeout(3000)

    //step8
    const Title2=await page.title()
    console.log("The second page title is: "+Title2)

    //step9
    const expTitle2="Search | shoes"
    await expect(expTitle2).toEqual(Title2)
    console.log("The second page title is verified!!!")

    //step10,11,12
    await page.locator("//span[@class='aisRefinementListLabelText']").first().click()
    await page.locator("//span[contains(text(),'Football boots')]").click()
    await page.locator("//span[contains(text(),'10.5')]").click()

    //step13,14
    await page.locator("//span[text()='Most Relevant']").click()
    await page.locator("//a[text()='Price: High to Low']").click()

    //step15,16
     await page.locator("//div[@class='swiper-slide swiper-slide-active']").first().click()
    await page.locator("//span[text()='BRAND SIZE']").click()
    await page.waitForTimeout(3000)
    await page.locator("//div[text()='UK 8 - EU 42']").click()
    await page.waitForTimeout(3000)
    
    //step17,18
    await page.getByLabel("addToCart").first().click()
    await page.waitForTimeout(3000)
    await page.locator("//p[text()='Cart']").click()
    await page.waitForTimeout(3000)

    //step19,20
    const cartTotal= await page.locator("//div[@data-test-id='cart:cart-checkout-total-cart-value']").innerText()
    console.log("Cart total amount is: "+cartTotal)
   





})