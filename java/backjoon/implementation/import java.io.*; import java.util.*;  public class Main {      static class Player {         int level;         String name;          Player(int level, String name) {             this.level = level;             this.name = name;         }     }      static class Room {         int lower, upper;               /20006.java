import java.io.*;
import java.util.*;

public class Main {

    static class Player {
        int level;
        String name;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }

    static class Room {
        int lower, upper;        
        List<Player> players = new ArrayList<>();

        Room(int firstLevel, Player firstPlayer) {
            this.lower = firstLevel - 10;
            this.upper = firstLevel + 10;
            players.add(firstPlayer);
        }

        boolean canEnter(Player p, int m) {
            if (players.size() >= m) return false;
            return lower <= p.level && p.level <= upper;
        }

        void add(Player p) {
            players.add(p);
        }

        boolean isStarted(int m) {
            return players.size() == m;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            Player player = new Player(level, name);

            boolean entered = false;
            for (Room room : rooms) {
                if (room.canEnter(player, m)) {
                    room.add(player);
                    entered = true;
                    break;
                }
            }

            if (!entered) {
                rooms.add(new Room(level, player));
            }
        }

        StringBuilder sb = new StringBuilder();

        for (Room room : rooms) {
            if (room.isStarted(m)) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            room.players.sort(Comparator.comparing(a -> a.name));

            for (Player pl : room.players) {
                sb.append(pl.level).append(" ").append(pl.name).append("\n");
            }
        }

        System.out.print(sb);
    }
}
