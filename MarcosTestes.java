import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Random;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MarcosTestes {
    private ChromeDriver driver;
    private WebDriverWait wait;
    private Alert alert;
    private static String name = "";
    private static String email = "";
    private Random random;
   @Before
    public void acessaUrl(){
        System.getProperty("webdriver.chrome.driver","chromedriver.exe");
        this.driver  = new ChromeDriver();
        wait = new WebDriverWait(driver, 90);
        this.driver.get("https://srbarriga.herokuapp.com/login");
        this.driver.manage().window().maximize();
}
    @Test
    public void aCadastroSucesso(){


        this.random = new Random();
        int number = random.nextInt() * 2;
        setName("Daniel" + number);
        setEmail("Daniel@h" + number);

         this.driver.findElement(By.xpath("//a[@href='/cadastro']")).click();

         this.driver.findElement(By.id("nome")).sendKeys(getName());
         this.driver.findElement(By.id("email")).sendKeys(getEmail());
         //this.driver.findElement(By.id("email")).sendKeys("teste2020@gmail.com");
         this.driver.findElement(By.id("senha")).sendKeys("teste2020");

         this.driver.findElement(By.xpath("//input[@value='Cadastrar']")).click();

         this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@role='alert']"))));
         String valorTela = this.driver.findElement(By.xpath("//div[@role='alert']")).getText();
         Assert.assertEquals("Usuário inserido com sucesso", valorTela);

        // this.driver.findElement(By.id("email")).sendKeys(getEmail());
        //  this.driver.findElement(By.id("senha")).sendKeys("teste2020");

        // his.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        // this.driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        //this.driver.findElement(By.xpath("//a[@href='/addConta']")).click();

        //this.driver.findElement(By.id("nome")).sendKeys(getName());
        //this.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //  this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@role='alert']"))));
        // String valorTela2 = this.driver.findElement(By.xpath("//div[@role='alert']")).getText();
        //Assert.assertEquals("Conta adicionada com sucesso!", valorTela2);

        //  this.driver.findElement(By.xpath("//a[@href='/movimentacao']")).click();

        //  this.driver.findElement(By.id("data_transacao")).sendKeys("25/03/2020");
        //this.driver.findElement(By.id("data_pagamento")).sendKeys("22/03/2020");
        // this.driver.findElement(By.id("descricao")).sendKeys("Queria uma namorada");
        //  this.driver.findElement(By.id("interessado")).sendKeys("Mais querer nao é poder");
        // this.driver.findElement(By.id("valor")).sendKeys("22");
        // this.driver.findElement(By.id("status_pago")).click();
        // this.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        // this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@role='alert']"))));
        // String valorTela3 = this.driver.findElement(By.xpath("//div[@role='alert']")).getText();
        // Assert.assertEquals("Movimentação adicionada com sucesso!", valorTela3);

    }
   @Test
    public void brealizarLogin(){


       this.wait.until(ExpectedConditions.elementToBeClickable(this.driver.findElement(By.xpath("//input[@name='email']"))));
       this.driver.findElement(By.id("email")).sendKeys(getEmail());
       this.driver.findElement(By.id("senha")).sendKeys("teste2020");
       this.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

    }
     @Test
    public void cCriarconta() throws InterruptedException {

         brealizarLogin();

        this.driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        this.driver.findElement(By.xpath("//a[@href='/addConta']")).click();

        this.driver.findElement(By.id("nome")).sendKeys(getName());
        this.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@role='alert']"))));
        String valorTela2 = this.driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", valorTela2);

    }

    @Test
    public void dMovimentacao() throws InterruptedException {

        brealizarLogin();

        this.driver.findElement(By.xpath("//a[@href='/movimentacao']")).click();

        this.driver.findElement(By.id("data_transacao")).sendKeys("25/03/2020");
        this.driver.findElement(By.id("data_pagamento")).sendKeys("22/03/2020");
        this.driver.findElement(By.id("descricao")).sendKeys("Queria uma namorada");
        this.driver.findElement(By.id("interessado")).sendKeys("Mais querer nao é poder");
        this.driver.findElement(By.id("valor")).sendKeys("22");
        this.driver.findElement(By.id("status_pago")).click();
        this.driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        this.wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(By.xpath("//div[@role='alert']"))));
        String valorTela3 = this.driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals("Movimentação adicionada com sucesso!", valorTela3);

    }

     @After
    public void fechaBrowser(){
          this.driver.quit();
    }
    public static String getName() {
        return name;
    }
    public static void setName(String name) {
        MarcosTestes.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        MarcosTestes.email = email;
    }

}