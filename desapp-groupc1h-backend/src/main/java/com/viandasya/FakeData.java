package com.viandasya;

import com.viandasya.model.menu.Category;
import com.viandasya.model.menu.DeliveryInfo;
import com.viandasya.model.menu.Menu;
import com.viandasya.model.menu.Offer;
import com.viandasya.model.order.Order;
import com.viandasya.model.order.OrderState;
import com.viandasya.model.timeslot.DateTimeSlot;
import com.viandasya.model.timeslot.DayTimeSlot;
import com.viandasya.model.timeslot.HoursTimeSlot;
import com.viandasya.model.timeslot.TimeTable;
import com.viandasya.model.user.Balance;
import com.viandasya.model.user.ClientProfile;
import com.viandasya.model.user.ServiceProfile;
import com.viandasya.model.user.User;
import com.viandasya.persistence.MenuRepository;
import com.viandasya.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import static com.viandasya.model.builders.timeslot.DateTimeSlotBuilder.anyDateTimeSlot;
import static com.viandasya.model.builders.timeslot.TimeTableBuilder.anyTimeTable;
import static com.viandasya.model.builders.user.ClientProfileBuilder.anyClientProfile;
import static com.viandasya.model.builders.user.ServiceInfoBuilder.anyServiceInfo;
import static com.viandasya.model.builders.user.ServiceProfileBuilder.anyServiceProfile;

@Component
public class FakeData implements ApplicationRunner {

    @Qualifier("userRepository")
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) {
        ////////////////////////////   SAVING USERS   ////////////////////////////

        //////////  USER 1 : SERVICE PROFILE WITH 2 MENUS  //////////

        Menu menu1 = anyMenu()
                .setOffers(create3OffersWith("200","180.5", "140", 20, 40))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(9,30),
                                LocalTime.of(17,30)),
                                new BigDecimal("40"), 30
                        ))
                .setValidity(anyDateTimeSlot()
                        .setSince(LocalDateTime.now().minusDays(10))
                        .setUntil(LocalDateTime.now().plusDays(10))
                        .createDateTimeSlot()
                )
                .setCategory(new ArrayList<>(Arrays.asList(Category.PIZZA, Category.HAMBURGER)))
                .setName("Menu para cumpleaños")
                .setCookingTime(30)
                .createMenu();

        Menu menu2 = anyMenu()
                .setOffers(create3OffersWith("299.99","220.4", "210", 25, 50))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(12,30),
                                LocalTime.of(20,30)),
                                new BigDecimal("50.5"), 23
                        ))
                .setValidity(anyDateTimeSlot()
                        .setSince(LocalDateTime.now())
                        .setUntil(LocalDateTime.now().plusDays(15))
                        .createDateTimeSlot()
                )
                .setCategory(new ArrayList<>(Arrays.asList(Category.EMPANADAS, Category.BEER, Category.SHSHI)))
                .setName("Menu con empanadas de pollo y carne, y tabla de sushi")
                .setCookingTime(40)
                .createMenu();

        ServiceProfile serviceProfile1 = anyServiceProfile()
                .setBalance(new Balance(new BigDecimal("20")))
                .setMenus(new ArrayList<>(Arrays.asList(menu1, menu2)))
                .createServiceProfile();


        ClientProfile clientProfile1 = anyClientProfile()
                .setName("Lisa")
                .setLastName("Romero")
                .setAdress("9 De Julio 500")
                .setCity("Quilmes")
                .setEmail("lisar.3467@gmail.com")
                .setBalance(new Balance(new BigDecimal("2000")))
                .createClientProfile();

        User user1 = new User();
        user1.addClientProfile(clientProfile1);
        user1.addServiceProfile(serviceProfile1);

        //////////  USER 2  //////////

        User user2 = new User();
        user2.addClientProfile(anyClientProfile().createClientProfile());

        //////////  USER A : SERVICE PROFILE WITH 2 MENUS  //////////

        Menu menua = anyMenu()
                .setOffers(create3OffersWith("399.99","350", "202.10", 50, 80))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(14,0),
                                LocalTime.of(18,0)),
                                new BigDecimal("40"), 15
                        ))
                .setValidity(anyDateTimeSlot()
                        .setSince(LocalDateTime.now().minusDays(25))
                        .setUntil(LocalDateTime.now())
                        .createDateTimeSlot()
                )
                .setCategory(new ArrayList<>(Arrays.asList(Category.GREEN, Category.VEGAN)))
                .setName("Menu muy green y sin tacc!")
                .setCookingTime(17)
                .createMenu();

        Menu menub = anyMenu()
                .setOffers(create3OffersWith("303.14","290.12", "250", 40, 53))
                .setDeliveryInfo(
                        new DeliveryInfo(createTimetableFromToOnWeekdays(LocalTime.of(20,0),
                                LocalTime.of(20,30)),
                                new BigDecimal("50.5"), 23
                        ))
                .setValidity(anyDateTimeSlot()
                        .setSince(LocalDateTime.now().minusDays(2))
                        .setUntil(LocalDateTime.now().plusDays(10))
                        .createDateTimeSlot()
                )
                .setCategory(new ArrayList<>(Collections.singletonList(Category.PIZZA)))
                .setName("Pizza especial con jamon, muzarrella y morron")
                .setCookingTime(25)
                .createMenu();

        ServiceProfile serviceProfilea = anyServiceProfile()
                .setServiceInfo(
                        anyServiceInfo()
                                .setName("Los Arandanos")
                                .setAdress("Lavalle 412")
                                .setLogo("xp")
                                .setEMail("arandanos.viandas.quilmes@gmail.com")
                                .setDescription("A veces, los sentimientos son difíciles de explicar," +
                                        " y qué sentimiento más fuerte que nuestro amor por la comida")
                                .setPhoneNumber(1143238310)
                                .setCity("Quilmes")
                                .createServiceInfo()
                )
                .setBalance(new Balance(new BigDecimal("300")))
                .setMenus(new ArrayList<>(Arrays.asList(menua, menub)))
                .createServiceProfile();

        ClientProfile clientProfilea = anyClientProfile()
                .setName("Miguel")
                .setLastName("Miloro")
                .setAdress("Av. La Madrid 2900")
                .setCity("Quilmes")
                .setEmail("miloromiguel@gmail.com")
                .setBalance(new Balance(new BigDecimal("500")))
                .createClientProfile();

        User usera = new User();
        usera.addClientProfile(clientProfilea);
        usera.addServiceProfile(serviceProfilea);

        User savedUser1 = userRepository.save(user1);
        User savedUser2 = userRepository.save(user2);
        User savedUsera = userRepository.save(usera);

        ////////////////////////////   CREATING ORDERS   ////////////////////////////

        Order order1 = anyOrder()
                .setAmount(5)
                .setOffers(new ArrayList<>(Collections.singletonList(
                        new Offer(20, new BigDecimal("180.5")))))
                .setScore(null)
                .setIsDelivery(false)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().plusDays(3), LocalDateTime.now().plusDays(3).plusHours(1)))
                .setState(OrderState.PENDING)
                .setClient(savedUser2.getClientProfile())
                .createOrder();

        Order order2 = anyOrder()
                .setAmount(6)
                .setOffers(new ArrayList<>(Collections.singletonList(new Offer(0, new BigDecimal("200")))))
                .setScore(null)
                .setIsDelivery(true)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().plusDays(4), LocalDateTime.now().plusDays(4).plusHours(1)))
                .setState(OrderState.PENDING)
                .setClient(savedUser2.getClientProfile())
                .createOrder();

        Order order3 = anyOrder()
                .setAmount(11)
                .setOffers(new ArrayList<>(Collections.singletonList(new Offer(0, new BigDecimal("200")))))
                .setScore(4)
                .setIsDelivery(false)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().minusDays(7), LocalDateTime.now().minusDays(7).plusHours(1)))
                .setState(OrderState.DELIVERED)
                .setClient(savedUsera.getClientProfile())
                .createOrder();

        Order ordera = anyOrder()
                .setAmount(35)
                .setOffers(new ArrayList<>(Collections.singletonList(new Offer(30, new BigDecimal("202.10")))))
                .setScore(null)
                .setIsDelivery(true)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().withHour(15),
                        LocalDateTime.now().minusDays(20).withHour(16)))
                .setState(OrderState.CONFIRMED)
                .setClient(savedUser1.getClientProfile())
                .createOrder();

        Order orderb = anyOrder()
                .setAmount(33)
                .setOffers(new ArrayList<>(Collections.singletonList(new Offer(30, new BigDecimal("202.10")))))
                .setScore(2)
                .setIsDelivery(true)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().minusDays(21).withHour(19),
                        LocalDateTime.now().minusDays(21).withHour(20)))
                .setState(OrderState.DELIVERED)
                .setClient(savedUsera.getClientProfile())
                .createOrder();

        Order orderc = anyOrder()
                .setAmount(21)
                .setOffers(new ArrayList<>(Collections.singletonList(new Offer(30, new BigDecimal("202.10")))))
                .setScore(5)
                .setIsDelivery(false)
                .setOrderDate(new DateTimeSlot(LocalDateTime.now().minusDays(10).withHour(14),
                        LocalDateTime.now().minusDays(21).withHour(15)))
                .setState(OrderState.DELIVERED)
                .setClient(savedUsera.getClientProfile())
                .createOrder();


        List<Menu> menus = (List<Menu>) menuRepository.findAll();
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

    private static List<Offer> create3OffersWith(String price, String minPrice1,
                                                 String minPrice2, Integer min1, Integer min2) {
        List<Offer> offers = new ArrayList<>();
        offers.add(new Offer( 0, new BigDecimal(price)));
        offers.add(new Offer( min1, new BigDecimal(minPrice1)));
        offers.add(new Offer( min2, new BigDecimal(minPrice2)));
        return offers;
    }

    private static TimeTable createTimetableFromToOnWeekdays(LocalTime from, LocalTime to) {
        List<DayOfWeek> weekdays = new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.THURSDAY, DayOfWeek.WEDNESDAY,
                DayOfWeek.TUESDAY, DayOfWeek.FRIDAY));
        List<DayTimeSlot> dayTimeSlots = new ArrayList<>();
        weekdays.forEach(weekday -> new DayTimeSlot(weekday,
                new ArrayList<>(Collections.singletonList(new HoursTimeSlot(from, to)))));

        return anyTimeTable().setDayTimeSlots(dayTimeSlots).createTimeTable();
    }

}
