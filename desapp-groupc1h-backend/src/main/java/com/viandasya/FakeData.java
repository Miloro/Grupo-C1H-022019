package com.viandasya;

import com.viandasya.model.menu.*;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;
import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.*;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.viandasya.model.builders.OrderBuilder.anyOrder;
import static com.viandasya.model.builders.menu.MenuBuilder.anyMenu;
import static com.viandasya.model.builders.menu.OfferBuilder.anyOffer;
import static com.viandasya.model.builders.menu.PriceHandlerBuilder.anyPriceHandler;
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;
import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;
import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;

@Component
public class FakeData implements ApplicationRunner {
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;

    public FakeData(UserRepository userRepository, MenuRepository menuRepository) {
        this.userRepository = userRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        ////////////////////////////   SAVING USERS   ////////////////////////////

        //////////  USER 1 : SERVICE PROFILE WITH 2 MENUS  //////////

        Menu menu1 = anyMenu()
                .setPriceHandler(createPriceHandler("200","180.5", "140", 20, 40))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(9,30),
                                LocalTime.of(17,30)),
                                new BigDecimal("40"), 30
                        ))
                .setValidity(anyDateTimeSlot()
                        .setFrom(LocalDateTime.now().minusDays(10))
                        .setTo(LocalDateTime.now().plusDays(10))
                        .createDateTimeSlot()
                )
                .setCategories(new ArrayList<>(Arrays.asList(Category.PIZZA, Category.HAMBURGER)))
                .setName("Menu para cumpleaños")
                .setDescription(" Para los chicos un exquisito menú de pizza libre de muzzarella, con agua mineral y gaseosas libres de primera marca")
                .setCookingTime(30)
                .createMenu();

        Menu menu2 = anyMenu()
                .setPriceHandler(createPriceHandler("299.99","220.4", "210", 25, 50))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(12,30),
                                LocalTime.of(20,30)),
                                new BigDecimal("50.5"), 23
                        ))
                .setValidity(anyDateTimeSlot()
                        .setFrom(LocalDateTime.now())
                        .setTo(LocalDateTime.now().plusDays(15))
                        .createDateTimeSlot()
                )
                .setCategories(new ArrayList<>(Arrays.asList(Category.EMPANADAS, Category.BEER, Category.SHSHI)))
                .setName("Menu con empanadas de pollo y carne, y tabla de sushi")
                .setDescription("Exquisitos sabores que harán de tus almuerzos y cenas momentos únicos.")
                .setCookingTime(40)
                .createMenu();

        ServiceProfile serviceProfile1 = anyServiceProfile()
                .setBalance("20")
                .setLocation(new Location("Alsina 654",
                        "Quilmes", -34.71688, -58.24964))
                .setMaxDistanceOfDeliveryInKms(5)
                .createServiceProfile();
        new ArrayList<>(Arrays.asList(menu1, menu2)).forEach(serviceProfile1::addMenu);



        ClientProfile clientProfile1 = anyClientProfile()
                .setName("Lisa")
                .setLastName("Romero")
                .setEmail("lisarmailfalso@gmail.com")
                .setLocation(new Location("Condarco 430", "Wilde", -34.7048199, -58.3264779))
                .setBalance(new Balance(new BigDecimal("2000")))
                .createClientProfile();

        User user1 = new User();
        user1.setEmail("lisarmailfalso@gmail.com");
        user1.addClientProfile(clientProfile1);
        user1.addServiceProfile(serviceProfile1);

        //////////  USER 2  //////////

        User user2 = new User();
        user2.setEmail("emailfalso@gmail.com");
        user2.addClientProfile(anyClientProfile().createClientProfile());

        //////////  USER A : SERVICE PROFILE WITH 2 MENUS  //////////

        Menu menua = anyMenu()
                .setPriceHandler(createPriceHandler("399.99","350", "202.10", 41, 80))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(14,0),
                                LocalTime.of(18,0)),
                                new BigDecimal("40"), 15
                        ))
                .setValidity(anyDateTimeSlot()
                        .setFrom(LocalDateTime.now().minusDays(25))
                        .setTo(LocalDateTime.now())
                        .createDateTimeSlot()
                )
                .setCategories(new ArrayList<>(Arrays.asList(Category.GREEN, Category.VEGAN)))
                .setName("Menu muy green y sin tacc!")
                .setDescription("Somos rico y sano. Somos sabores honestos. Somos fast good. Somos un menu muy green y sin tacc!")
                .setCookingTime(17)
                .createMenu();

        Menu menub = anyMenu()
                .setPriceHandler(createPriceHandler("303.14","290.12", "250", 40, 53))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(20,0),
                                LocalTime.of(20,30)),
                                new BigDecimal("50.5"), 23
                        ))
                .setValidity(anyDateTimeSlot()
                        .setFrom(LocalDateTime.now().minusDays(2))
                        .setTo(LocalDateTime.now().plusDays(10))
                        .createDateTimeSlot()
                )
                .setCategories(new ArrayList<>(Collections.singletonList(Category.PIZZA)))
                .setName("Pizza especial con jamon, muzarrella y morron")
                .setDescription("En este menu conocerás auténticas pizzas hechas a mano, no podrá resistirse el suave aroma a comida")
                .setCookingTime(25)
                .createMenu();

        ServiceProfile serviceProfilea = anyServiceProfile()
                .setServiceInfo(
                        anyServiceInfo()
                                .setName("Los Arandanos")
                                .setLogo("https://basket.com/wp-content/uploads/2017/11/android-chrome-256x256.png")
                                .setEMail("arandanos.viandas.quilmes@gmail.com")
                                .setDescription("A veces, los sentimientos son difíciles de explicar," +
                                        " y qué sentimiento más fuerte que nuestro amor por la comida")
                                .setPhoneNumber(1143238310)
                                .createServiceInfo()
                )
                .setBalance("300")
                .setLocation(new Location("Avenida Calchaquí 1233",
                        "Quilmes Oeste", -34.7394801, -58.2923969))
                .setMaxDistanceOfDeliveryInKms(10)
                .createServiceProfile();
        new ArrayList<>(Arrays.asList(menua, menub)).forEach(serviceProfilea::addMenu);

        ClientProfile clientProfilea = anyClientProfile()
                .setName("Miguel")
                .setLastName("Miloro")
                .setEmail("pepito@gmail.com")
                .setLocation(new Location("Uruguay 2200", "Ezpeleta Oeste",
                        -34.7597263, -58.2642824))
                .setBalance(new Balance(new BigDecimal("500")))
                .createClientProfile();

        User usera = new User();
        usera.setEmail("pepito@gmail.com");
        usera.addClientProfile(clientProfilea);
        usera.addServiceProfile(serviceProfilea);

        ClientProfile savedClient1 = userRepository.save(user1).getClientProfile();
        ClientProfile savedClient2 = userRepository.save(user2).getClientProfile();
        ClientProfile savedClienta = userRepository.save(usera).getClientProfile();

        ////////////////////////////   CREATING ORDERS   ////////////////////////////

        Order order1 = anyOrder()
                .setAmount(20)
                .setOffer(new Offer(20, new BigDecimal("180.5")))
                .setScore(null)
                .setIsDelivery(false)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(1)))
                .setState(OrderState.PENDING)
                .setClient(savedClient2)
                .createOrder();

        Order order2 = anyOrder()
                .setAmount(10)
                .setOffer(new Offer(0, new BigDecimal("200")))
                .setScore(null)
                .setIsDelivery(true)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().plusDays(4), LocalDateTime.now().plusDays(4).plusHours(1)))
                .setState(OrderState.PENDING)
                .setClient(savedClient2)
                .createOrder();

        Order order3 = anyOrder()
                .setAmount(11)
                .setOffer(new Offer(0, new BigDecimal("200")))
                .setScore(4)
                .setIsDelivery(false)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().minusDays(7), LocalDateTime.now().minusDays(7).plusHours(1)))
                .setState(OrderState.DELIVERED)
                .setClient(savedClienta)
                .createOrder();

        Order ordera = anyOrder()
                .setAmount(35)
                .setOffer(new Offer(30, new BigDecimal("202.10")))
                .setScore(null)
                .setIsDelivery(true)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().withHour(15),
                        LocalDateTime.now().minusDays(20).withHour(16)))
                .setState(OrderState.CONFIRMED)
                .setClient(savedClient1)
                .createOrder();

        Order orderb = anyOrder()
                .setAmount(33)
                .setOffer(new Offer(30, new BigDecimal("202.10")))
                .setScore(2)
                .setIsDelivery(true)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().minusDays(21).withHour(19),
                        LocalDateTime.now().minusDays(21).withHour(20)))
                .setState(OrderState.DELIVERED)
                .setClient(savedClienta)
                .createOrder();

        Order orderc = anyOrder()
                .setAmount(21)
                .setOffer(new Offer(30, new BigDecimal("202.10")))
                .setScore(5)
                .setIsDelivery(false)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().minusDays(10).withHour(14),
                        LocalDateTime.now().minusDays(21).withHour(15)))
                .setState(OrderState.DELIVERED)
                .setClient(savedClienta)
                .createOrder();


        List<Menu> menus = menuRepository.findAll();
        Menu menuGreen = menus.stream()
                .filter(menu -> menu.getName().equals("Menu muy green y sin tacc!"))
                .findFirst().get();
        Menu menuPizza = menus.stream()
                .filter(menu -> menu.getName().equals("Pizza especial con jamon, muzarrella y morron"))
                .findFirst().get();

        new ArrayList<>(Arrays.asList(order1, order2, order3)).forEach(menuGreen::addOrder);
        new ArrayList<>(Arrays.asList(ordera, orderb, orderc)).forEach(menuPizza::addOrder);

        menuRepository.save(menuGreen);
        menuRepository.save(menuPizza);
    }

    private static PriceHandler createPriceHandler(String price, String minPrice1,
                                                   String minPrice2, Integer min1, Integer min2) {
        Offer current = anyOffer().setPrice(price).setMinAmount(0).createOffer();
        List<Offer> offers = new ArrayList<>();
        offers.add(anyOffer().setPrice(minPrice1).setMinAmount(min1).createOffer());
        offers.add(anyOffer().setPrice(minPrice2).setMinAmount(min2).createOffer());
        return anyPriceHandler()
                .setCurrent(current)
                .setOffers(offers)
                .createPriceHandler();
    }

    private static TimeTable createTimetableFromToOnWeekdays(LocalTime from, LocalTime to) {
        List<DayOfWeek> weekdays = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.THURSDAY, DayOfWeek.WEDNESDAY,
                DayOfWeek.TUESDAY, DayOfWeek.FRIDAY));
        List<DayTimeSlot> dayTimeSlots = new ArrayList<>();
        weekdays.forEach(weekday -> dayTimeSlots.add(new DayTimeSlot(weekday,
                new ArrayList<>(Collections.singletonList(new HoursTimeSlot(from, to))))));

        return anyTimeTable().setDayTimeSlots(dayTimeSlots).createTimeTable();
    }

}
