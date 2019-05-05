package utils;

import domain.mainObject.Movie;
import domain.mainObject.MovieRepository;

public class InputCheckUtils {
        public static void checkInputReservationMoive(int input) throws Exception {
                if (input <= MovieConstants.zero)
                        throw new Exception("음수 또는 0 입력 오류");
                if (!checkValidMoiveId(input))
                        throw new Exception("상영 번호 입력 오류");
                return;
        }

        private static boolean checkValidMoiveId(int input) {
                boolean valid = false;
                for (Movie movie : MovieRepository.getMovies()) {
                        valid = movie.compareId(input) ? true : valid;
                }
                return valid;
        }

        public static void checkInputReservationSchedule(int movieId, int selectedSchedule) throws Exception {
                boolean valid = false;
                if (selectedSchedule <= MovieConstants.zero)
                        throw new Exception("음수 또는 0 입력 오류");
                for (Movie movie : MovieRepository.getMovies()) {
                        valid = movie.hasSchedule(movieId, selectedSchedule) ? true : valid;
                }
                if (!valid) {
                        throw new Exception("예약 시간표 번호 초과 입력 오류");
                }
                return;
        }

        public static void checkInputMoviePeople(int movieId, int schedule, int people) throws Exception {
                boolean valid = false;
                if (people <= MovieConstants.zero)
                        throw new Exception("음수 또는 0 입력 오류");
                for (Movie movie : MovieRepository.getMovies()) {
                        valid = movie.isValidPeople(movieId, schedule, people) ? true : valid;
                }
                if (!valid) {
                        throw new Exception("예약 인원 수 초과 입력 오류");
                }
                return;
        }

        public static void checkInputPayOrAdd(int select) throws Exception {
                if (select != MovieConstants.selectPayment && select != MovieConstants.selectAddReservation)
                        throw new Exception("결제, 추가 입력 오류 (1또는 2입력)");
        }


        public static void checkInputPoint(int point) throws Exception{
                if (point < 0)
                        throw new Exception("음수 입력 오류");
        }

        public static void checkInputCardOrCash(int cardOrCash) throws Exception {
                if (cardOrCash != MovieConstants.selectCard && cardOrCash != MovieConstants.selectCash)
                        throw new Exception("신용카드,현금 결제 입력 오류 (1또는 2입력)");
        }
}
