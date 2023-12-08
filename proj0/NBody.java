public class NBody {

    public static double readRadius(String filename){
        In file = new In(filename);
        int N = file.readInt();
        return file.readDouble();
    }

    public static Planet[] readPlanets(String filename){
        In file = new In(filename);
        int N = file.readInt();
        double r = file.readDouble();
        Planet[] planets = new Planet[N];
        for (int i = 0; i < N; i++){
            planets[i] = new Planet(file.readDouble(), file.readDouble(),file.readDouble(),file.readDouble(),file.readDouble(),file.readString());
        }
        return planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]), dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double universe_radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        String background_img = "images/starfield.jpg";
        StdDraw.setScale(-universe_radius, universe_radius);
        StdDraw.picture(0, 0, background_img);
        for (Planet p : planets){
            p.draw();
        }
        StdDraw.enableDoubleBuffering();
        for (double time = 0; time < T; time += dt){
            double[] xForces = new double[planets.length], yForces = new double[planets.length];
            for (int i = 0; i < planets.length; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, background_img);
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        System.out.printf("%d\n", planets.length);
        System.out.printf("%.2e\n", universe_radius);
        for (Planet p : planets){
            System.out.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);
        }
    }
}
