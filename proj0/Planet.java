public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos)  + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
        double G = 6.67e-11;
        double r = (this.calcDistance(p));
        return (G * mass * p.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet p){
        double F = this.calcForceExertedBy(p), r = this.calcDistance(p), dx = p.xxPos - xxPos;
        return F * (dx / r);
    }

    public double calcForceExertedByY(Planet p){
        double F = this.calcForceExertedBy(p), r = this.calcDistance(p), dy = p.yyPos - yyPos;
        return F * (dy / r);
    }

    public double calcNetForceExertedByX(Planet[] ps){
        double Fx = 0;
        for (Planet p : ps){
            if(!this.equals(p)) {
                Fx += this.calcForceExertedByX(p);
            }
        }
        return Fx;
    }

    public double calcNetForceExertedByY(Planet[] ps){
        double Fy = 0;
        for (Planet p : ps){
            if(!this.equals(p)) {
                Fy += this.calcForceExertedByY(p);
            }
        }
        return Fy;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / mass, ay = fY / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
