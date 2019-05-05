import domain.mainObject.Movie;
import domain.mainObject.MovieRepository;
import domain.utilObject.ReservedInfo;
import domain.utilObject.ReservedMoive;
import utils.MovieConstants;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MovieApplication {
        public static void main(String[] args) {
                List<Movie> movies = MovieRepository.getMovies();
                OutputView.printMovies(movies);

                ReservedInfo reservedInfo = new ReservedInfo();
                do {
                        int movieId = InputView.inputMovieId();
                        OutputView.printSelectedMovie(movieId);

                        int schedule = InputView.inputMovieSchedule(movieId);

                        int people = InputView.inputMoviePeople(movieId, schedule);
                        reservedInfo.addMovie(new ReservedMoive(movieId,schedule,people));
                } while (InputView.inputPayOrAdd() == MovieConstants.selectAddReservation);
                OutputView.printReservationInfo();
        }
}
