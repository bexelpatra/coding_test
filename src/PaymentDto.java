//@Data
public class PaymentDto {

    // private int id; // 아이디
    // private PaymentEnum paymentEnum; // 결제수단
    // private int orderId; // 오더 아이디
    // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    // private Date useDate; // 거래일시
    // private int useAmount; // 금액
    public static void main(String[] args) {
        String a = "varchar  varchar varchar varchar timestamp varchar varchar timestamp varchar varchar";
        a = a.toUpperCase();
        System.out.println(a.replaceAll(" ", System.lineSeparator()));

    }
}
