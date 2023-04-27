package util;

import java.io.Serializable;

public class MsgRequest implements Serializable {
        private  double value1, value2;
        private char operation;

        
        public MsgRequest(double value1, double value2, char operation) {
            this.value1 = value1;
            this.value2 = value2;
            this.operation = operation;
        }


        public double getValue1() {
            return value1;
        }


        public double getValue2() {
            return value2;
        }


        public char getOperation() {
            return operation;
        }

        

}
