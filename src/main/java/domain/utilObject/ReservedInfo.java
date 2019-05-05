package domain.utilObject;

import java.util.ArrayList;
import java.util.List;

public class ReservedInfo {
        private List<ReservedMoive> moiveList;
        int totalFare;

        public ReservedInfo() {
                this.moiveList = new ArrayList<ReservedMoive>();
                this.totalFare = 0;
        }

        public void addMovie(ReservedMoive reservedMoive) {
                try {
                        this.moiveList.add(reservedMoive);
                        this.totalFare += reservedMoive.getFare();
                } catch (Exception e) {

                }
        }

        public void printInfo() {
                StringBuilder sb = new StringBuilder();
                for (ReservedMoive reservedMoive : this.moiveList) {
                        sb.append(reservedMoive.toString());
                }
                System.out.println(sb.toString());
        }

        public int getDiscountFare(int point) {
                return this.totalFare - point;
        }
}
