package domain.mainObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
        private static final char NEW_LINE = '\n';

        private final int id;
        private final String name;
        private final int price;

        private List<PlaySchedule> playSchedules = new ArrayList<>();

        public Movie(int id, String name, int price) {
                this.id = id;
                this.name = name;
                this.price = price;
        }

        void addPlaySchedule(PlaySchedule playSchedule) {
                playSchedules.add(playSchedule);
        }

        @Override
        public String toString() {
                StringBuilder sb = new StringBuilder();
                for (PlaySchedule playSchedule : playSchedules) {
                        sb.append(playSchedule);
                }
                return id + " - " + name + ", " + price + "원" + NEW_LINE
                        + sb.toString();
        }

        public String toStringInfo(int scheduleNo, int people) {
                StringBuilder sb = new StringBuilder();
                sb.append(id + " - " + name + ", " + price + "원" + NEW_LINE);
                sb.append(playSchedules.get(scheduleNo - 1).toStringInfo());
                sb.append("예약 인원: " + people + NEW_LINE);
                return sb.toString();
        }

        public boolean compareId(int movieId) {
                return this.id == movieId;
        }

        public boolean hasSchedule(int movieId, int schedule) {
                return (this.id == movieId && schedule <= this.playSchedules.size());
        }

        public boolean isValidPeople(int movieId, int schedule, int people) {
                return (this.id == movieId && this.playSchedules.get(schedule - 1).isValidPeople(people));
        }

        public int getFare(int people){
                return this.price*people;
        }
}
