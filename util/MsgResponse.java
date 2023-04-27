package util;

import java.io.Serializable;

public class MsgResponse implements Serializable{
        private Status status;
        private double value;

        public MsgResponse(Status status, double value) {
            this.status = status;
            this.value = value;
        }
        
        public Status getStatus() {
            return status;
        }
        
        public double getValue() {
            return value;
        }

        
}


