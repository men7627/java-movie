package domain.utilObject;

import domain.mainObject.Movie;
import domain.mainObject.MovieRepository;

public class ReservedMoive {
        private Movie movie = null;
        private int scheduleNo;
        private int people;

        public ReservedMoive(int moiveId, int scheduleNo, int people) {
                for (Movie movie : MovieRepository.getMovies()) {
                        this.movie = movie.compareId(moiveId) ? movie : this.movie;
                }
                this.scheduleNo = scheduleNo;
                this.people = people;
        }

        public int getFare(){
                return this.movie.getFare(this.people);
        }

        @Override
        public String toString() {
                return this.movie.toStringInfo(scheduleNo, people);
        }
}
