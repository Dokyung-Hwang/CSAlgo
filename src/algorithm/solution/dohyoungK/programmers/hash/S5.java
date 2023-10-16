package algorithm.solution.dohyoungK.programmers.hash;

import algorithm.problem.programmers.hash.P5;

import java.util.*;

public class S5 implements P5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "popa", "clic", "clssic", "po"}, new int[]{5, 3, 4, 2, 1})));
    }

    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> playSum = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> songs = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            int sum = playSum.getOrDefault(genres[i], 0);
            sum += plays[i];
            playSum.put(genres[i], sum);

            PriorityQueue<Song> songPq = songs.getOrDefault(genres[i], new PriorityQueue<>());
            songPq.add(new Song(i, plays[i]));
            songs.put(genres[i], songPq);
        }

        PriorityQueue<Genre> genrePq = new PriorityQueue<>();
        for (String name : playSum.keySet()) {
            genrePq.add(new Genre(name, playSum.get(name)));
        }

        while (!genrePq.isEmpty()) {
            Genre genre = genrePq.poll();
            PriorityQueue<Song> pq = songs.get(genre.name);
            for (int i = 0; i < 2; i++) {
                if (!pq.isEmpty()) {
                    result.add(pq.poll().index);
                }
            }
        }

        return result.stream().mapToInt(e -> e).toArray();
    }
    public static class Genre implements Comparable<Genre> {
        private String name;
        private int playSum;

        public Genre(String name, int playSum) {
            this.name = name;
            this.playSum = playSum;
        }

        @Override
        public int compareTo(Genre genre) {
            if (this.playSum < genre.playSum)
                return 1;
            else
                return -1;
        }
    }
    public static class Song implements Comparable<Song> {
        private int index;
        private int play;

        public Song(int index, int play) {
            this.index = index;
            this.play = play;
        }


        @Override
        public int compareTo(Song song) {
            if (this.play < song.play)
                return 1;
            else if (this.play > song.play)
                return -1;
            else {
                if (this.index > song.index) return 1;
                else return -1;
            }
        }
    }
}
