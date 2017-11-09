import java.math.BigDecimal;

public class HelloWorld {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Float f1 = 74.02f;
      System.out.println("float f1=" + f1);
      Float f2 = f1 * 100;
      System.out.println("float f1 * 100 =" + f2 + ", longvalue=" + f2.longValue());
      System.out.println("float f1 * 100 =" + f2 + ", rounded=" + Math.round(f2));
      BigDecimal b1 = new BigDecimal(f1);
      System.out.println("BigDecimal b1=" + b1);
      System.out.println("scale =" + b1.scale());
      BigDecimal b2 = b1.setScale(2,BigDecimal.ROUND_HALF_UP);
      System.out.println("BigDecimal b2=" + b2);
      System.out.println("scale =" + b2.scale());
      System.out.println("b2.multiply(new BigDecimal(100) =" + b2.multiply(new BigDecimal(100)));
      long l = b2.multiply(new BigDecimal(100)).longValue();
      System.out.println("long l =" + l);
      System.out.println("b2.scaleByPowerOfTen(2) =" + b2.scaleByPowerOfTen(2));
      System.out.println(" using convertToPence(b1)=" + convertToPence(b1));

      for (long l1 = 0; l1 <= 10000; l1++) {
         float f3 = l1;
         f3 = f3 / 100;
         float f4 = f3 * 100;
         if (f4 != l1) {
            //System.out.println("rounding error l1=" + l1 + ", f3=" + f3 + ", f4=" + f4);
            BigDecimal b3 = convertFromPence(l1);
            long l2 = convertToPence(b3);
            if (l1 != l2) {
               System.out.println("rounding error l1=" + l1 + ", l2=" + l2);

            }

         }

      }



   }

   private static long convertToPence(BigDecimal value) {
      BigDecimal bigD = value.setScale(2,BigDecimal.ROUND_HALF_UP);

      return bigD.multiply(new BigDecimal(100)).longValue();
   }

   private static BigDecimal convertFromPence(long value) {
      BigDecimal bigD1 = new BigDecimal(value);
      BigDecimal bigD2 = bigD1.setScale(2,BigDecimal.ROUND_HALF_UP);

      return bigD2.divide(new BigDecimal(100));
   }
}
