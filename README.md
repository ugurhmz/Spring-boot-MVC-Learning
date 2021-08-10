# Önder Teker - Derinlemesine Enterprise Java 4 : IoC, CDI & Spring Boot  Tuttuğum Notlar :
Spring, Spring Boot Web, MVC, Data, ORM, REST, Configuration, AOP, Security, Thymeleaf,Spring CRUD

-  1 ) Spring MVC’de Controller ile çalışır. @Controller anatasyonu sınıfın üstüne konur. Web’den erişilebilir demektir.

-  2)@GetMapping(“/test”)  -> Route verir.
 @ResponseBody -> içeriğin kendisini üretir. alttaki metodu. Eğerki bu anatasyon yoksa. Views olarak algılar, sayfayı açar.

- 3 ) JSTL  VE JSP için pom.xml içine : 
<dependency>
	            <groupId>org.apache.tomcat.embed</groupId>
	            <artifactId>tomcat-embed-jasper</artifactId>
	        </dependency>
	          <dependency>
	        <groupId>javax.servlet</groupId>
	        <artifactId>jstl</artifactId>
	    </dependency>
- 4 ) src->main->webapp folder oluştur ve altına ->

- 5 ) MVC’de her zaman önce, Controller çalışcak.
- 6 ) Kullanıcıya gösterilmek istenmeyen şeyler için özellike .jsp files’lar ->  BUNU SAAĞLAMAK İÇİN WEB-INF Folderi oluşturulur.
src->main->webapp->WEB-INF folderi oluştur -> jsp folder oluştur. Sonra .jsp Sayfaları oraya koy.

- 7 ) Doğrudan WEB-INF ulaşmak için, src/main/resources -> application.properties içine : 
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp


-  8 ) JSTL
model.addAttribute("ismi","değeri")   -> .html içinde çağrılma şekli ise : ${message}  şeklinde çağırabiliriz
*Önce @Controller bulunuyor. Sonra veri sayfada gösterilcek hale getiriliyor.

JSTL kullanmak için -> .jsp şunu ekle :
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

Not 
@GetMapping({"/parametric/variable/{myId}","/parametric/variable/"})
**@PathVariable(name="myId", required = false) Long myId
eğerki değer gelmezse de  işlet manasında. Object türünde verdik myId, çünkü required = false. myıd gelmezse Null vericek, myid gelirse onu basacaz.

@PathVariable() -> direk id yi alır.
@RequestParam( name=”myId” ) long myId  -> soldaki name kısmını alıyor, sağdaki taraftaki myId kısmıan koyuyor.
Kullanım şekli : http://localhost:8080/parametric/requestpage?myId=3123123

@RequestParam( name=”myId”, defaultValue=”0” ) long myId  -> 
http://localhost:8080/parametric/requestpage   -> böyle girersek defaultValue devreye girer. biz metodu String tanımladığımız için int değerlerini “0” böyle veriyoruz.

**Not ->Belirleyici,ayırt edici özellikleri id gibi, type gibi path’e koyuyoruz. Opsiyonel olanları  requeste koyuyoruz.

GET’ler, POSTLAR @Controller ile 
GET -> @GetMapping
POST-> @PostMapping  

GET & POST -> ikiside aynı path’e map ediyoruz. 
örn: @GetMapping(“/editing/employee”)
     @PostMapping(“/editin/employee”)

*form’da kullanılan ->  modelAttribute=”addAttribute kullanılan 1.parametre”  verilir.


**Kullanıcının girdiklerini bir entity, model olarak, nesne olarak,çekirdek olarak  oluşturur.

** Türkçe karakter sorunu için -> charset=”utf-8”

** Ekrana getirenler -> getter 
Post ile gönderilenler ->setter’larını çağırıyor.

Validation için -> (.... BindingResult  result ) parametresi verilir
ve if(result.hasError()) {} ->Hata vvarsa  şunu yap.


*Not -> <form:errors />   ->Genel Hatayı gösterir.
	   new ObjectError();

Not -> new FieldError() -> Nesnenin altındaki yer için 

** <form:errors path=” ” /> ->  Burdaki path controller’daki yerde kullanılır.

SPRING ORM
1-	new spring starter project
2-	name ->	springorm
3-	package -> com.ugurhmz.springorm sonra next
4-	 web kısmından ->Spring web
SQL kısmından -> Spring Data JPA 
			  MySQL Driver

5) Id olduğunu belirtiyoruz  ve Kendinden Artsın diyoruz,
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)

6)MySQL -> create schema -> springcustomerdb
7) Veri tabanını bilgileri için  -> application.properties ‘e ekliyoruz.
8) * Spring tersi söylenmediği sürece -> Hibernate ile çalışır.
spring.jpa.hibernate.ddl-auto -> create     //yoksa yaratır, varsa dokunmaz. 
	update //Veritabanındaki tabloları kendisi yaratır.
	none // Saten tablo varsa none yapılır.

**9) Bundan Sonrasında ise Biz entity yaparız, Entity veri tabanında saklamak içinde Sınıf yaparız ve genelliklede Repository denir. 





10) CustomerRepository.java interfacesini oluştur ve extends 

11) CrudRepository<Entity’i_YazBuraya, Entity’deki ID’nin TİPİ> 
   // Bir nesneyle ilgili Temel operasyonları bu yapar.

12) CustomerController Sınıfı oluştur.

13) ** @AutoWired -> IoC’nin ya da Dependency Injection’un Kullanıldığı, çalıştırıldığı anatasyon. Bu anatasyon Dependency Injection yapıyor. Yani Verdiğimiz interface’yi implemente eden sınıfı getir buraya koy demek.

14) Dışardan verilen parametre ile çalıştırmak için.
@RequestParam(name = "name") String customerName,
@RequestParam(name="debit") double totalCredit) 
	{
Customer customer = new Customer(0,customerName,totalCredit);
}

şeklinde yazılır.
Kullanımı : localhost:8080/customer/persist?name=Silay Guven&debit=5124123


15) Optional<> java 8 ve sonrası kullanılıma sürülmüş. NullPointer hatalarından kurtarmaya çalışıyor.

16) update işleminde -> id si ile bul, sonra set et
		

1. Önce bul optional ile :
Optional<Customer> optional = customerRepository.findById(customerId);

2. Sonra sil veya güncelle : 
	if(optional.isPresent()) {
		sil veya güncelle burda...
		}


17) *Not -> Sayfa getirmiyorsak, ekrana sadece bir şey basmak için @ResponseBody  kullanılır.
18) .findAll() -> Iterable<> Döndürür. 

19) @Repository -> Bu class repository olarak kullanılcak demektir. Bunun içinde biz istediğimiz JPA sorgunusu yapabiliriz demektir.

20) Sorguları çalıştırmak için se bize EntityManager lazım.

SPRING REST
1	 ) spring new project -> spring web, rest repositories -> finish
2) html üretmek yerine, xml veya json üretiliyor.
3) Sınıfın üstüne @RestController yazılması o sınıfı REST Services veya rest servisleri içeren bir sınıf haline getirir.

4) service classı -> Entity olabilir, DTO(Data Transfer Object) varlıklardan oluşan bir nesne olabilir, Model gibi nesne olabilir. AMa sonuçta JSON’a çevirilen bir nesne olacak.

5) @RestController varsayılan olarak json ile çalışır.
6) Eğerki JSON tipinde olsun demek istiyorsak.
@GetMapping(value="/sports/player", produces=MediaType.APPLICATION_JSON_VALUE)

Bu şekilde .

7) Bir REST SERVICE, bir başka rest service bağlanabilir ve ordan veri alabilir.

8) Genelde bir Veri türü için bir rest yapılır, hepsi onun altına konulur.

9) REST Service istemcisi yine Spring gibi bir web uygulaması olabilir.

10) RestTemplate -> REST ile bir yerden bir şey istemenin, kolay yoludur.

*11 ) JSON’u kullanıcıya göstermek istersek -> onu parse Etmemiz gerek.
*12 Not ) JSP çağırmıyorsak, @ResponseBody dememiz gerek.

13 Not ) Hem istemci, Hem servis erişmesi için ortak bir yere koyarlar. 
14) Json yerine direk nesnede istenebilir. 

15) Bütün yöntemler GET,POST,DELETE,PUT .exchange kullanır.
requestEntity veriyoruz, responseEntity alıyoruz.

16)  *Method not allow , status=405 ->Böyle bir url var ama GET ile istiyorsun, burası POST ile çalışıyor.

17 ) *Not -> @GetMapping("/client/send")
	@ResponseBody
	public String sendPlayer( ) {}  
şeklinde /client/send  çağırırsak ->  içinde yazan String url kısmına, restTemplate ile yollanacakları söylüyoruz.

18) Not* -> ResponseEntity<> Eğerki gelen status’a göre işlem yapacaksak bunu kullanmak daha mantıklı.

TİPİK BİR UYGULAMA ŞUNLARI YAPAR
ORM 
MVC
REST SERVICE (Birileri Size Bağlanır)
REST SERVICE ( Biz Bağlanırız)

UYGULAMA YAPISI
1 )  MySQL Driver, Spring Web, Spring DATA JPA, REST REPOSITORIES

2) src/main/java -> 
     com.ugurhmz.springapp.data.entity 
     com.ugurhmz.springapp.data.repository
     com.ugurhmz.springapp.data.presentation.mvc

3)* Bir entity varsa onu DB’ye yazan repository interfacesi vardır.
*CrudRepository’e karşılık ekle,çıkar,listele gibi yöntemlere karşılık @Controller Sınıfı vardır.
4)@Controller kullanmak için @Autowired ile O repository’i inject etmeliyiz.


5) @Controller sınıfında @GetMapping ile ekrana getir, @PostMapping ile insert yap.
* Model model kullanmalısın ve nesne oluşturup boş, model.addAttribute() yapmalısın.

*BindingResult result -> hata varsa şuraya yönlendir gibi yerlerde kullanılır.

6) Ana sınıfı Bean olaıa @Entity yap.


7) src ->main -> webapp -> WEB-INF -> jsp -> inventory  folderlerini sırayla oluştur

8) Dosya dizilerini tanıması için application.properties şunları ekle
spring.mvc.view.prefix =/WEB-INF/jsp/
spring.mvc.view.suffix =.jsp

9) Veri Tabanı için ayarları yine aynı yere application.properties ekle

10) JSP ayarlarını pom.xml ekle




11) NOT : Genel olarak yapı şu şekilde  -> 
		Entity ( @Entity )
		Repository ( CrudRepository<T,ID> )
		Controller ( GetMapping, PostMapping )
		
12) Business katmanı asıl işin yapıldığı yerdir -> ne arayüzle ilgili olucak, ne veritabanıyla

13) ** Bir servisin aldığı, verdiği veriye -> DTO denir
DTO -> entity ile model arasında bir veri.

DTO ->    fieldlar + GETTER & SETTER + Constructor dolu veboş.
SERVİCE -> Genellikle interface yapılır. ve bunu implemente eden class yapılır.

14) implemente eden sınıfın başına @Service anatasyonu konur.

15) Orta katman business layer olduğundan , bir daha controller’in veri tabanına doğrudan erişmesi olmayacak.

16) Servisi implemenete eden class’ta görev, Entity olan değerleri, DTO’dan almak.

17 ) Karmaşık durumlarda Entity ile DTO aynı olmayabilir, DTO Bağımsız ve bellekte yaşayan bir nesne.

18) Entity’i doğrudan kullanmıyoruz, DTO ile çalışıyoruz.

19) Repository’i doğrudan kullanma hakkı kalkar business layer ile, onun yerine service kullanılır.

20) Businesslayer neden yapılır? : bürokrasi olur. Araya birini koyuyoruz ondan istiyoruz ve oda ondan istiyor. Bunu yapmamızın sebebi arada denetleme yapabilelim diye. Veri tabanıyla araya katman = Businesslayer = service


21) Orta katmanda ->Mantığı yaptık, dönüşümleri yaptık. Burda ilke ne Entity göreceğiz, ne de repository’i göreceğiz.

22) Bu 3 katmanlı yapılış, Spring için önerilen bir yoldur, sanki tek yol buymuş gibi anlatılır. Çünkü IoC, AOP gibi özellik bunlara göre yapılır. KURUMSAL PROGRAMLAMA İÇİN GEREKLİ OLDUĞUNU DÜŞÜNEBİLİRSİNİZ.


23) Özet olarak ->
 1- DB ile interface olan Service konuşur.
 2- Controller service ile konuşuyor.

24) DTO sınıflarının özelliği doğrudan json veya xml’e çevrilebilmesi.

25)Her zaman orta katmanda logic olmalı.

26) ÖZET OLARAK BİR UYGULAMADA
	1- MVC önde duracak
	2- Service ortada duracak
	3- Repository’de arkada duracak
4-	Service görevi DTO parçalayıp, repositorye vermek



_________________________________ DEVAMI ________________________________

1- Genellikle her Entity'e bir DTO yapıyoruz
Sebebi ise Direk Entity'leri dış dünyaya açmak güvenlik açığına sebep olcağından, DTO yapıyoruz.

2- Entity Nesnesini Controller ve Service  katmanında kullanmamız bir takım hatalara neden olabilir.

3-Genelde ANA Entity'ler için DTO yapılır , yardımcılar için yapılmayabilir.
*Sadece gösterim yapılacaksa gerek yok fakat düzenleme veya kendine ait sayfası varsa DTO yapabilriiz.

______________________________________________________________________________________________________
			SERVICE LAYER
		com.ugurhmz.springcomplex.business.service


1- Interface sınıfı oluşturulur.
2- gövdesiz metodlar, ana DTO ile ilgili yapılacak işlemler için metodlar tanımlanır.
*Not -> create, update, delete void tipinde tanımlanır.
	findById, list -> Bunların geri dönüş tipi vardır.


		       SERVICE IMPL LAYER


Servis katmanında uygulamanın iş mantığı ile ilgili işlemler ve süreçler yürütülür. 
Ayrıca servis katmanı karşımıza transaction yönetimi, güvenlik kontrolleri, validasyon gibi 
middleware operasyonların yönetim yeri olarak da çıkmaktadır.
		

		com.ugurhmz.springcomplex.business.impl
1- Service'yi implements yapılır.
2- @Service anatasyonu class level tanımlanır.
3- impl classı repository kullanacak. Ve bunu @Autowired ile kullanacak.
.......................


			TRANSACTION
Veri tabanındaki birden çok işlemi ya yap, ya yapma. Yani yarım bırakma hiç bir şeyi
Db'deki engine yerini -> InnoDB yapmak gerek çünkü MyISAM transaction olayını desteklemiyor

*Hepsini birden oluşturmaya çalışan fakat bir hata oluncada oluşmaması gerekendir transaction.

@Transactional anatasyonu olan metod veya sınıfta ya yap, ya da yapma olur
eğerki hata varsa yapma, yoksa yap.


** Transactional içinden öbür transactional'in çağrılması konusu

@Transactional(propagation = Propagation.REQUIRED)  -> Beni doğrudan çağırıyorsan bir transactional başlat
fakat BİR ŞEYİN içinde çağırıyorsan transaction başlatma, var olan transactionun içine sok.
Yani birinin içinde öbür transaction'ı çalıştırcaz.

_____________________________________________________________________________________________
					CONFIGURATION
**Önemli 
1- Configirasyon yapmanın 2 yolu var -> 
	1.XML (Klasik yöntem)
	2.JAVA (Source kodda yapmak)

2- Configuration şu -> Bir @Bean tanımlamak ve onu başka bir yerden kullanılabilir hale getirmek.
3- @Bean -> Olan metot'ta verileri de set ediyoruz.

*Not -> @Bean  içi dolu veri demek
*Not2 -> Bean'i dışardan nasıl kullanırım ? 
Cevap : Injection ile yani @Autowired ile

3- Configuration'da amaç -> Uygulamanın kullandığı alt yapıyla ilgili bilgilendirme ve nesneleri oluşturmak
o yüzden adına yapılandırma diyoruz. JPA kuruyoruz, mesajlaşmayı kuruyoruz, loglamayı kuruyoruz gibi..

4- Singleton ->Tek bir nesne yaratılması
@Scope("prototype") -> Her bir durum için yeni bir tane üret

5- Configuration -> Başlangıçta ve Sonda çalışan, asıl iş mantığıyla ilgili olmayan
nesnelerle ilgilidir

6- Genelde configurationlarda dosyalardan bir şeyler okuyor, diğer @Bean ise üstüne bir şeyler ekliyor.
7- Configuration'da amaç bir kez kurgulayıp, bir dahada kullanılmasını sağlamak. 
Boşu boşuna herkes oluşturmasın

8- xml içindeki property name='' kısmı bunlar o classtaki
fieldların ismi, değerleri ise value adı altında veriliyor.


@NotEmpty -> Boş olamaz 

Not** -> @Valid Controller sınıfında Post olan mapping yerinde yazılır
	@Valid ->Bir beanin validasyonunu zorluyor.

__________________________________________________________________________________________
					AOP
Burda amacımız : iş mantığına karışmadan, en kısa işlevsellik vermek.

AOP -> Veritabanına eklenen bütün kayıtların, kütüğünü tut bize haberini ver. Ya da say kaçtane eklendi
ya da kim ekledi

Aspect -> bir sınıftır ve aspect sınıfı olması için @Aspect anatasyonu uygulanmalı. Sınıfın
tanınması içinde @Configuration olmalı.
Yani Aspect bir sınıf için

@Aspect
@Configuration
public class...      şeklinde olmalı

not ->   @Before -> ise Dinleyeceğimiz yeri gösteriyor.
	JoinPoint -> Çağrıldığı durum demek
	

@Before("execution(* com.ugurhmz.springaop.module.sales.*.*(..))")  -> şu demek:
bu modulun altındaki herhangi bir sınıf, onun içindeki herhangi bir metod ve herhangi bir  parametre alsın
beni çağırcaksın. 
@Before'un metoduyla beraber yaptığı şeye -> Advice denir.
	

* Tam o noktada, o doğrultada kes bizi çağır.

* Doğrulama(Authentication)
* Yetkilendirme (Autherization)


@Before("execution(* com....)")   -> * ile com arasında boşluk olması gerek yoksa hata veriyor.



*Not -> @After -> Yöntem Çağrıldıktan sonra devreye giriyor. Yani işler bitti ondan sonra yapılcak şeyler.
	@Around -> Çalışma esnasında ve aslında yöntemide çalıştıran bu.
		   Burda proceed() kullanılıyor ve ilerle demek. Intercept bunla yapılıyor.
		  -@Before'dan da önce çağrılıyor bu ve bütün sistemi bu kapsıyor. Sonra @Before
		   Çağrılıyor işi yapıyoruz sonra @After 

AOP advice -> Şu durumda bunu yap demek
*Birçok kişi için @After, @Before gerek yok @Around ile halledilebilir.
_____________________________________________________________________________________________________________________________________
						SPRING SECURITY
Authentication -> Doğrulama
Autherization -> Yetkilendirme


*Not -> Biz security sisteme dahil ettiğimiz anda  şifre sorar. Kimin neye erişceğini baştan söylüyoruz.yoksa şifre korumalı olur
@EnableWebSecurity ->Security'i devre dışı bırakmaya yarar. Ve configure(HttpSecurity http) içi boş şekilde yaparsak security off olmuş
olur.

*Not2 -> Bütün sistemi sen yönetiyosun ondan araya girip ekle çıkar yapıyorsun.

.authorizeRequests() -> Önüne her geleni alma devamında gelen ile şu şekilde al demek.
.and() ile ->Http geri dönülür.

.httpBasic() ->Herhangi bir sayfa yapmadan authentication sağlanır. Daha çok REST'lerde kullanılır. Ve Http'nin kendi yapısı

.formLogin() -> basic ile form getirir.


not3 -> UserSecurity'de ise .password() ile encrypt oluyor şifreler  bunu istemiyorsak
.password("{noop}sarman")  -> Şeklinde şifresiz olur 

auth
	.inMemoryAuthentication()  //Authenticationu bellekten yapıcam, DB'ye şuan için gerek yok.
	.withUser("ugur")	//Bir tane kullanıcı aç bana
	.password("{noop}sarman") 		//Şifresi olsun ve encrypt encoded etme
	.roles("USER");		


*Not4 -> Configuration'da @Bean ne demekti ? : ->Biz @Bean tanımlıyoruz, her yerden inject edilebilir.


.antMatchers("/","/home") -> gibi path'lerde security olsun


*Not5 -> .antMatchers("/","/home")
	 .permitAll()
	Tüm yukardaki /,/home pathlerine izin ver fakat onun dışındakileri authenticate et aşağıdakiyle.
	.anyRequest()
	.authenticated()
	.....


*Not6 ->  .loginPage("/mycustomLoginPage") -> Şeklinde bizim kendiminiz yaptığı logine gitsin
	  .defaultSuccessUrl("/home")  -> Girişi yaptıktan sonra buraya gitsin.


**To many redirect varsa -> o path'i serbest hale getirmen gerek. Yani herkes login sayfasını açabilsin.


* logout ->authentication önce bul sonra çık demek

*authentication ile sistemde şuan kim var onu bulmuş oluruz.

*Not7 -> .invalidateHttpSession(true)  -> Çıkış yapınca sessionda kalan verileri yok et. Oturumu sıfırlıyorki yeni gelen kullanıcıda
eski kullanıcın verileri kalmasın.



.with -> şeklinde başlayanlar şu demek : yeni bir şey set et demek


.antMatchers("/low/*").hasAnyRole("ADMIN","USER") -> /low pathiyle başlayanlara ADMIN ve USER'de erişebilsin
.antMatchers("/high/*").hasRole("ADMIN") -> /high pathinde ise ADMIN olsun.


*Not8 -> Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); 	//VAR OLAN KULLANCYI VERİR
for(GrantedAuthority authority : authentication.getAuthorities()) {
	builder.append(authority.getAuthority()).append(" "); // KULLANICININ İÇİNDEN HANGİ YETKİLERİ VAR DIR BU GÖSTERİYOR
			}


method securation ->Genellikle servis katmanına yapılması gerekiyor. Çünkü
orta katmanda ve herhangi sayafadan erişmeye çalıştığında buraya koymak daha mantıklı


implemente eden sınıfta -> 	@Secured("ROLE_ADMIN") ->Sadece admin olanlar çağırır bu methodu.

*Not -> jsr250 -> standart olan, springin kendine özgü değildir.
@RolesAllowed("ROLE_ADMIN") şeklinde kullanılır. jsr250 göre



Not -> .httpBasic() -> Kullanıcının önüne form açmaz, header'da ister.

_____________________________________ THYMELEAF ______________________________________________________

1- templates ->index.html oluştur ve
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">


2- thymeleaf ta her şeyi expression algılaması. ve bundan dolayı şu şekilde yaz
<h1 th:text="'Hello world'"></h1>      // Tek tırnak içinde ve </h1> kapanışı zorunlu


3- ${}  ->Şeklinde Dolar varsa, Spring ile ilgili model.addAttribute ile ilgili


4- @{}  -> @ ifadesi burda, static kaynakların bulunduğu konumun köküne göre yap demektir.






