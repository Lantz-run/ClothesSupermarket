package com.Lantz.ui;

import com.Lantz.FrameWork.BeanFactory;
import com.Lantz.bean.Clothes;
import com.Lantz.bean.Order;
import com.Lantz.bean.OrderItem;
import com.Lantz.service.ClothesService;
import com.Lantz.service.OrderService;
import com.Lantz.service.impl.ClothesServiceImpl;
import com.Lantz.service.impl.OrderServiceImpl;
import com.Lantz.utils.BusinessException;
import com.Lantz.utils.ConsoleTable;
import com.Lantz.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class HomeClass extends BaseClass{

   private OrderService orderService ;
   private ClothesService clothesService ;

   public HomeClass(){
       clothesService = (ClothesService) beanFactory.getBean("clothesService");
       orderService = (OrderService) beanFactory.getBean("orderService");
   }

    public void show() {
        showProducts();
        println("welcome:" + currUser.getUsername());
        menu();

    }

    // menu()��Ҫ����ʹ�ã����������ﵥ����menu����һ������
    private void menu(){
        boolean flag = true;
        while (flag){
            println(getString("home.function"));
            println(getString("info.select"));
            String select = input.nextLine();
            switch (select){
                case "1": // ��ѯȫ������
                    findList();
                    flag = false;
                    break;
                case "2": // ���Ҷ���
                    findOrderById();
                    flag = false;
                    break;
                case "3": // ����
                    try {
                        buyProducts();
                        flag = false;
                    }catch(BusinessException e){
                        println(e.getMessage());
                    }
                    break;
                case "0": // �˳�
                    flag = false;
                    println(getString("info.exit"));
                    System.exit(0);
                    break;
                default:
                    println(getString("input.error"));
                    break;
            }
        }
    }


    /**
     * ������Ʒ
     * @throws BusinessException
     */
    private void buyProducts() throws BusinessException {
        // ���ɶ���
        boolean flag = true;
        int count = 1; // ������
        float sum = 0.0f; // �����ܶ�
        Order order = new Order(); // ���ɵĶ���
        while (flag){
            println(getString("product.input.id"));
            String id = input.nextLine();
            println(getString("product.input.shoppingNum"));
            String shoppingNum = input.nextLine();
            OrderItem orderItem = new OrderItem();
            Clothes clothes = clothesService.findById(Integer.parseInt(id)); // �ַ���ת����
            int num = Integer.parseInt(shoppingNum);
            if (num > clothes.getNum()){
                throw new BusinessException("product.num.error");
            }

            // һ��������ϸ
            clothes.setNum(clothes.getNum() - num); // ��ȥ���
            orderItem.setClothes(clothes);
            orderItem.setShoppingNum(num);
            orderItem.setSum(clothes.getPrice()*num);
            sum += orderItem.getSum();
            orderItem.setItemId(count++);
            order.getOrderItemList().add(orderItem);
//            order.setCreateData();
            println(getString("product.buy.continue"));
            String isBuy = input.nextLine();
            switch (isBuy){
                case "1":
                    flag = true;
                    break;
                case "2":
                    flag = false;
                    break;
            }

        }
        order.setCreateData(DateUtils.toDate(new Date()));
        order.setUserId(currUser.getId());
        order.setSum(sum);
        order.setOrderId(orderService.list().size() + 1);
        orderService.buyProducts(order);
        clothesService.update();
        show();

    }

    // ��ѯ�����б�
    private void findOrderById() {
        println(getString("product.order.input.oid"));
        String oid = input.nextLine();
        Order order = orderService.findById(Integer.parseInt(oid));
        if (order != null){
            showOrder(order);
        }else {
            println(getString("product.order.error"));
        }
        menu();
    }

    private void showOrder(Order o) {
        print(getString("product.order.oid") + o.getOrderId());
        print("\t"+getString("product.order.createDate") + o.getCreateData());
        println("\t"+getString("product.order.sum") + o.getSum());
        ConsoleTable t = new ConsoleTable(9, true);
        t.addRow("id", "brand", "style", "color", "size", "num", "price", "description", "sum");

    }

    private void findList() {
        List<Order> list = orderService.list();
        for (Order o : list
             ) {
            showOrder(o);
        }
        menu();
    }


    private void showProducts() {
        List<Clothes> list = clothesService.list();
        ConsoleTable table = new ConsoleTable(9, true);
        table.addRow("id", "brand", "style", "color", "size", "num", "price", "description", "sum");

        for (Clothes c : list
             ) {
            table.addRow(c.getId(),
                    c.getBrand(),
                    c.getStyle(),
                    c.getColor(),
                    c.getSize(),
                    c.getNum(),
                    c.getPrice(),
                    c.getDescription(),
                    c.getSum());
        }
        println(table.toString());
    }

}
