package view;

import utils.InputCheckUtils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
        private static final Scanner scanner = new Scanner(System.in);

        public static int inputMovieId() {
                System.out.println("\n## 예약할 영화를 선택하세요.");
                try {
                        int input = inputInt();
                        InputCheckUtils.checkInputReservationMoive(input);
                        return input;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputMovieId();
                }
        }

        public static int inputMovieSchedule(int movieId) {
                System.out.println("## 예약할 시간표를 선택하세요. (첫번째 상영 시간이 1번)");
                try {
                        int selectedSchedule = inputInt();
                        InputCheckUtils.checkInputReservationSchedule(movieId, selectedSchedule);
                        return selectedSchedule;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputMovieSchedule(movieId);
                }
        }


        public static int inputMoviePeople(int movieId, int schedule) {
                System.out.println("\n## 예약할 인원을 입력하세요.");
                try {
                        int people = inputInt();
                        InputCheckUtils.checkInputMoviePeople(movieId, schedule, people);
                        return people;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputMoviePeople(movieId, schedule);
                }
        }

        public static int inputPayOrAdd() {
                System.out.println("\n## 예약을 종료하고 결제를 진행하려면 1번, 추가 예약을 진행하려면 2번");
                try {
                        int select = inputInt();
                        InputCheckUtils.checkInputPayOrAdd(select);
                        return select;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputPayOrAdd();
                }
        }

        public static int inputPoint(){
                System.out.println("## 결제를 진행합니다.");
                System.out.println("## 포인트 사용 금액을 입력하세요. 포인트가 없으면 0 입력");
                try {
                        int point = inputInt();
                        InputCheckUtils.checkInputPoint(point);
                        return point;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputPoint();
                }
        }

        public static int inputCardOrCash(){
                System.out.println("\n## 신용카드는 1번,현금은 2번");
                try {
                        int cardOrCash = inputInt();
                        InputCheckUtils.checkInputCardOrCash(cardOrCash);
                        return cardOrCash;
                } catch (Exception e) {
                        System.err.println(e);
                        return inputCardOrCash();
                }
        }

        private static int inputInt() {
                try {
                        return scanner.nextInt();
                } catch (InputMismatchException e) {
                        scanner.nextLine();
                        System.err.println("입력 형식 오류");
                        return inputInt();
                }
        }
}
