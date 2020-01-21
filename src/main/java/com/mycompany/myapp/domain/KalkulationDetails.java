package com.mycompany.myapp.domain;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;

/**
 * A KalkulationDetails.
 */
@Entity
@Table(name = "kalkulation_details")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class KalkulationDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "a")
    private String a;

    @Column(name = "b")
    private String b;

    @Column(name = "c")
    private String c;

    @Column(name = "d")
    private String d;

    @Column(name = "e")
    private String e;

    @Column(name = "f")
    private String f;

    @Column(name = "g")
    private String g;

    @Column(name = "h")
    private String h;

    @Column(name = "i")
    private String i;

    @Column(name = "j")
    private String j;

    @Column(name = "k")
    private String k;

    @Column(name = "l")
    private String l;

    @Column(name = "m")
    private String m;

    @Column(name = "n")
    private String n;

    @Column(name = "o")
    private String o;

    @Column(name = "p")
    private String p;

    @Column(name = "q")
    private String q;

    @Column(name = "r")
    private String r;

    @Column(name = "s")
    private String s;

    @Column(name = "t")
    private String t;

    @Column(name = "u")
    private String u;

    @Column(name = "v")
    private String v;

    @Column(name = "w")
    private String w;

    @Column(name = "x")
    private String x;

    @Column(name = "y")
    private String y;

    @Column(name = "z")
    private String z;

    @Column(name = "aa")
    private String aa;

    @Column(name = "ab")
    private String ab;

    @Column(name = "ac")
    private String ac;

    @Column(name = "ad")
    private String ad;

    @Column(name = "ae")
    private String ae;

    @Column(name = "af")
    private String af;

    @Column(name = "ag")
    private String ag;

    @ManyToOne
    @JsonIgnoreProperties("kalkulationDetails")
    private Kalkulation kalkulation;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getA() {
        return a;
    }

    public KalkulationDetails a(String a) {
        this.a = a;
        return this;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public KalkulationDetails b(String b) {
        this.b = b;
        return this;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public KalkulationDetails c(String c) {
        this.c = c;
        return this;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public KalkulationDetails d(String d) {
        this.d = d;
        return this;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getE() {
        return e;
    }

    public KalkulationDetails e(String e) {
        this.e = e;
        return this;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getF() {
        return f;
    }

    public KalkulationDetails f(String f) {
        this.f = f;
        return this;
    }

    public void setF(String f) {
        this.f = f;
    }

    public String getG() {
        return g;
    }

    public KalkulationDetails g(String g) {
        this.g = g;
        return this;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getH() {
        return h;
    }

    public KalkulationDetails h(String h) {
        this.h = h;
        return this;
    }

    public void setH(String h) {
        this.h = h;
    }

    public String getI() {
        return i;
    }

    public KalkulationDetails i(String i) {
        this.i = i;
        return this;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getJ() {
        return j;
    }

    public KalkulationDetails j(String j) {
        this.j = j;
        return this;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getK() {
        return k;
    }

    public KalkulationDetails k(String k) {
        this.k = k;
        return this;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getL() {
        return l;
    }

    public KalkulationDetails l(String l) {
        this.l = l;
        return this;
    }

    public void setL(String l) {
        this.l = l;
    }

    public String getM() {
        return m;
    }

    public KalkulationDetails m(String m) {
        this.m = m;
        return this;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getN() {
        return n;
    }

    public KalkulationDetails n(String n) {
        this.n = n;
        return this;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getO() {
        return o;
    }

    public KalkulationDetails o(String o) {
        this.o = o;
        return this;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getP() {
        return p;
    }

    public KalkulationDetails p(String p) {
        this.p = p;
        return this;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getQ() {
        return q;
    }

    public KalkulationDetails q(String q) {
        this.q = q;
        return this;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getR() {
        return r;
    }

    public KalkulationDetails r(String r) {
        this.r = r;
        return this;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getS() {
        return s;
    }

    public KalkulationDetails s(String s) {
        this.s = s;
        return this;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getT() {
        return t;
    }

    public KalkulationDetails t(String t) {
        this.t = t;
        return this;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getU() {
        return u;
    }

    public KalkulationDetails u(String u) {
        this.u = u;
        return this;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getV() {
        return v;
    }

    public KalkulationDetails v(String v) {
        this.v = v;
        return this;
    }

    public void setV(String v) {
        this.v = v;
    }

    public String getW() {
        return w;
    }

    public KalkulationDetails w(String w) {
        this.w = w;
        return this;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getX() {
        return x;
    }

    public KalkulationDetails x(String x) {
        this.x = x;
        return this;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public KalkulationDetails y(String y) {
        this.y = y;
        return this;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getZ() {
        return z;
    }

    public KalkulationDetails z(String z) {
        this.z = z;
        return this;
    }

    public void setZ(String z) {
        this.z = z;
    }

    public String getAa() {
        return aa;
    }

    public KalkulationDetails aa(String aa) {
        this.aa = aa;
        return this;
    }

    public void setAa(String aa) {
        this.aa = aa;
    }

    public String getAb() {
        return ab;
    }

    public KalkulationDetails ab(String ab) {
        this.ab = ab;
        return this;
    }

    public void setAb(String ab) {
        this.ab = ab;
    }

    public String getAc() {
        return ac;
    }

    public KalkulationDetails ac(String ac) {
        this.ac = ac;
        return this;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public String getAd() {
        return ad;
    }

    public KalkulationDetails ad(String ad) {
        this.ad = ad;
        return this;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAe() {
        return ae;
    }

    public KalkulationDetails ae(String ae) {
        this.ae = ae;
        return this;
    }

    public void setAe(String ae) {
        this.ae = ae;
    }

    public String getAf() {
        return af;
    }

    public KalkulationDetails af(String af) {
        this.af = af;
        return this;
    }

    public void setAf(String af) {
        this.af = af;
    }

    public String getAg() {
        return ag;
    }

    public KalkulationDetails ag(String ag) {
        this.ag = ag;
        return this;
    }

    public void setAg(String ag) {
        this.ag = ag;
    }

    public Kalkulation getKalkulation() {
        return kalkulation;
    }

    public KalkulationDetails kalkulation(Kalkulation kalkulation) {
        this.kalkulation = kalkulation;
        return this;
    }

    public void setKalkulation(Kalkulation kalkulation) {
        this.kalkulation = kalkulation;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KalkulationDetails)) {
            return false;
        }
        return id != null && id.equals(((KalkulationDetails) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "KalkulationDetails{" +
            "id=" + getId() +
            ", a='" + getA() + "'" +
            ", b='" + getB() + "'" +
            ", c='" + getC() + "'" +
            ", d='" + getD() + "'" +
            ", e='" + getE() + "'" +
            ", f='" + getF() + "'" +
            ", g='" + getG() + "'" +
            ", h='" + getH() + "'" +
            ", i='" + getI() + "'" +
            ", j='" + getJ() + "'" +
            ", k='" + getK() + "'" +
            ", l='" + getL() + "'" +
            ", m='" + getM() + "'" +
            ", n='" + getN() + "'" +
            ", o='" + getO() + "'" +
            ", p='" + getP() + "'" +
            ", q='" + getQ() + "'" +
            ", r='" + getR() + "'" +
            ", s='" + getS() + "'" +
            ", t='" + getT() + "'" +
            ", u='" + getU() + "'" +
            ", v='" + getV() + "'" +
            ", w='" + getW() + "'" +
            ", x='" + getX() + "'" +
            ", y='" + getY() + "'" +
            ", z='" + getZ() + "'" +
            ", aa='" + getAa() + "'" +
            ", ab='" + getAb() + "'" +
            ", ac='" + getAc() + "'" +
            ", ad='" + getAd() + "'" +
            ", ae='" + getAe() + "'" +
            ", af='" + getAf() + "'" +
            ", ag='" + getAg() + "'" +
            "}";
    }
}
