package view;

import domain.mainObject.Movie;
import domain.mainObject.MovieRepository;
import domain.utilObject.ReservedInfo;


import java.util.List;


public class OutputView {
        public static void printMovies(List<Movie> movies) {
                System.out.println("상영 영화 목록");
                for (Movie movie : movies) {
                        System.out.println(movie);
                }
        }

        public static void printSelectedMovie(int movieId) {
                Movie selectedMovie = null;
                for (Movie movie : MovieRepository.getMovies()) {
                        selectedMovie = movie.compareId(movieId) ? movie : selectedMovie;
                }
                System.out.println(selectedMovie);
        }

        public static void printReservedInfo(ReservedInfo reservedInfo) {
                System.out.println("예약 내역");
                reservedInfo.printInfo();
        }

        public static void printFinishMessage(int point,ReservedInfo reservedInfo){
                System.out.println("\n최종 결제한 금액은 " + reservedInfo.getDiscountFare(point)+"원 입니다.");
                System.out.println("예매를 완료했습니다.즐거운 영화 관람되세요.\n");
        }
}
