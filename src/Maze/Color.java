package Maze;

public class Color
{
    public static final class Foreground
    {
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
        
        public static final class Bold
        {
            public static final String BLACK = "\033[1;30m";  // BLACK
            public static final String RED = "\033[1;31m";    // RED
            public static final String GREEN = "\033[1;32m";  // GREEN
            public static final String YELLOW = "\033[1;33m"; // YELLOW
            public static final String BLUE = "\033[1;34m";   // BLUE
            public static final String PURPLE = "\033[1;35m"; // PURPLE
            public static final String CYAN = "\033[1;36m";   // CYAN
            public static final String WHITE = "\033[1;37m";  // WHITE
            
            public static final class Bright
            {
                public static final String BLACK = "\033[1;90m"; // BLACK
                public static final String RED = "\033[1;91m";   // RED
                public static final String GREEN = "\033[1;92m"; // GREEN
                public static final String YELLOW = "\033[1;93m";// YELLOW
                public static final String BLUE = "\033[1;94m";  // BLUE
                public static final String PURPLE = "\033[1;95m";// PURPLE
                public static final String CYAN = "\033[1;96m";  // CYAN
                public static final String WHITE = "\033[1;97m"; // WHITE
            }
        }
        
        public class Bright
        {
            public static final String BLACK = "\033[0;90m";  // BLACK
            public static final String RED = "\033[0;91m";    // RED
            public static final String GREEN = "\033[0;92m";  // GREEN
            public static final String YELLOW = "\033[0;93m"; // YELLOW
            public static final String BLUE = "\033[0;94m";   // BLUE
            public static final String PURPLE = "\033[0;95m"; // PURPLE
            public static final String CYAN = "\033[0;96m";   // CYAN
            public static final String WHITE = "\033[0;97m";  // WHITE
            
            
            public static final class Bold
            {
                public static final String BLACK = "\033[1;90m"; // BLACK
                public static final String RED = "\033[1;91m";   // RED
                public static final String GREEN = "\033[1;92m"; // GREEN
                public static final String YELLOW = "\033[1;93m";// YELLOW
                public static final String BLUE = "\033[1;94m";  // BLUE
                public static final String PURPLE = "\033[1;95m";// PURPLE
                public static final String CYAN = "\033[1;96m";  // CYAN
                public static final String WHITE = "\033[1;97m"; // WHITE
            }
        }
    }
    
    public static final String RESET = "\u001B[0m";
    
    public static final class Background
    {
        public static final String BLACK = "\u001B[40m";
        public static final String RED = "\u001B[41m";
        public static final String GREEN = "\u001B[42m";
        public static final String YELLOW = "\u001B[43m";
        public static final String BLUE = "\u001B[44m";
        public static final String PURPLE = "\u001B[45m";
        public static final String CYAN = "\u001B[46m";
        public static final String WHITE = "\u001B[47m";
        
        public static final class Bright
        {
            public static final String BLACK = "\033[0;100m";// BLACK
            public static final String RED = "\033[0;101m";// RED
            public static final String GREEN = "\033[0;102m";// GREEN
            public static final String YELLOW = "\033[0;103m";// YELLOW
            public static final String BLUE = "\033[0;104m";// BLUE
            public static final String PURPLE = "\033[0;105m"; // PURPLE
            public static final String CYAN = "\033[0;106m";  // CYAN
            public static final String WHITE = "\033[0;107m";   // WHITE
        }
    }
}