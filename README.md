<h1>mallang-kongth</h1>
<h2>반려동물을 위한 자동 급식/자동 급수 Iot를 제공하는 웹 서비스</h2>
<a href="https://github.com/onejm/ArduinoForMallang-Kongth"><img src="https://github.com/Tarikul-Islam-Anik/Animated-Fluent-Emojis/blob/master/Emojis/Animals/Otter.png" width ="3%"/>아두이노 레포지토리</a>

```
mallangkongth
│       │           ├── Controller
│       │           │   ├── File
│       │           │   │   └── FileController.class
│       │           │   ├── HelloWorldController.class
│       │           │   ├── HomeController.class
│       │           │   ├── ItemController.class
│       │           │   ├── LoginController.class
│       │           │   ├── MemberController.class
│       │           │   ├── OrderController.class
│       │           │   ├── PetController.class
│       │           │   ├── RearingController.class
│       │           │   ├── SessionConst.class
│       │           │   └── SessionPet.class
│       │           ├── MallangKongthApplication.class
│       │           ├── config
│       │           │   ├── MvcConfiguration.class
│       │           │   ├── SecurityConfig.class
│       │           │   ├── SecurityUtil.class
│       │           │   ├── SessionManager.class
│       │           │   └── WebConfiguration.class
│       │           ├── domain
│       │           │   ├── community
│       │           │   │   ├── Category.class
│       │           │   │   ├── Sex.class
│       │           │   │   ├── Time.class
│       │           │   │   ├── board
│       │           │   │   │   ├── Board$BoardBuilder.class
│       │           │   │   │   ├── Board.class
│       │           │   │   │   └── BoardCategory.class
│       │           │   │   └── comment
│       │           │   │       ├── BoardComment.class
│       │           │   │       ├── Comment.class
│       │           │   │       ├── InformationComment.class
│       │           │   │       ├── MissingComment.class
│       │           │   │       └── QuestionComment.class
│       │           │   ├── file
│       │           │   │   ├── FileEntity$FileEntityBuilder.class
│       │           │   │   └── FileEntity.class
│       │           │   ├── mypage
│       │           │   │   ├── Address.class
│       │           │   │   ├── Breed.class
│       │           │   │   ├── CartItem.class
│       │           │   │   ├── CategoryItem.class
│       │           │   │   ├── CategoryOfItem.class
│       │           │   │   ├── ChangePwReqDto.class
│       │           │   │   ├── Delivery.class
│       │           │   │   ├── DeliveryStatus.class
│       │           │   │   ├── Item.class
│       │           │   │   ├── ItemForm.class
│       │           │   │   ├── JoinForm.class
│       │           │   │   ├── LoginForm.class
│       │           │   │   ├── Member.class
│       │           │   │   ├── MemberDto.class
│       │           │   │   ├── MemberForm.class
│       │           │   │   ├── OrderItem.class
│       │           │   │   ├── OrderSearch.class
│       │           │   │   ├── OrderStatus.class
│       │           │   │   ├── Orders.class
│       │           │   │   ├── Pet.class
│       │           │   │   ├── PetForm.class
│       │           │   │   ├── RoleType.class
│       │           │   │   └── WaterBowlItem.class
│       │           │   └── rearing
│       │           │       ├── FoodBowl.class
│       │           │       ├── FoodNote.class
│       │           │       ├── FoodServing.class
│       │           │       ├── FoodServingForm.class
│       │           │       ├── FoodServingTime.class
│       │           │       ├── Health.class
│       │           │       ├── HealthForm.class
│       │           │       ├── HospitalNote.class
│       │           │       ├── HospitalNoteForm.class
│       │           │       ├── Ingredient.class
│       │           │       ├── Walking.class
│       │           │       ├── WalkingForm.class
│       │           │       ├── WaterBowl.class
│       │           │       └── WaterNote.class
│       │           ├── dto
│       │           │   ├── BoardDto.class
│       │           │   ├── FoodServingTimeDto.class
│       │           │   ├── HospitalFormDto.class
│       │           │   └── PetFormDto.class
│       │           ├── repository
│       │           │   ├── BoardRepository.class
│       │           │   ├── CategoryRepository.class
│       │           │   ├── FileRepository.class
│       │           │   ├── FoodBowlRepository.class
│       │           │   ├── FoodNoteRepository.class
│       │           │   ├── FoodServingRepository.class
│       │           │   ├── FoodServingTimeRepository.class
│       │           │   ├── HealthRepository.class
│       │           │   ├── HospitalRepository.class
│       │           │   ├── ItemRepository.class
│       │           │   ├── MemberRepository.class
│       │           │   ├── OrderRepository.class
│       │           │   ├── PetRepository.class
│       │           │   ├── WalkingRepository.class
│       │           │   ├── WaterBowlRepository.class
│       │           │   └── WaterNoteRepository.class
│       │           ├── serial
│       │           │   ├── FoodBowlRenwal.class
│       │           │   ├── FoodBowlSerialReadThread.class
│       │           │   ├── FoodBowlSerialWriteThread.class
│       │           │   ├── WaterBowlRenewal.class
│       │           │   └── WaterBowlSerialReadThread.class
│       │           └── service
│       │               ├── CategoryService.class
│       │               ├── FileService.class
│       │               ├── HealthService.class
│       │               ├── HospitalService.class
│       │               ├── ItemService.class
│       │               ├── LoginService.class
│       │               ├── MemberService.class
│       │               ├── OrderService.class
│       │               ├── PetService.class
│       │               ├── WalkingService.class
│       │               └── WaterBowlService.class
```


<h3 data-ke-size="size20"><b>Front-End :</b></h3>
<h4 data-ke-size="size20"><b>Thymeleaf</b></h4>
<h3 data-ke-size="size20"><b>Sever :</b></h3>
<h4 data-ke-size="size20"><b>Tomcat/AWS</b></h4>
<h3 data-ke-size="size20"><b>Authentication :</b></h3>
<h4 data-ke-size="size20"><b>spring-security5</b></h4>
<h3 data-ke-size="size20"><b>DB :</b></h3>
<h4 data-ke-size="size20"><b>Mysql</b></h4>
