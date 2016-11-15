/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.ClassRoom;
import entities.Hour;
import entities.Lesson;
import entities.Program;
import entities.ProgramClass;
import entities.ProgramClassRoom;
import entities.ProgramHour;
import entities.ProgramLesson;
import entities.ProgramTeacher;
import entities.School;
import entities.Teacher;
import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Abdullah Gürlek <abdullah.gurlek3 at gmail.com>
 */
public class SchoolTest {

    private final Configuration cfg;
    private final SessionFactory sessionFactory;
    private final Session session;

    public SchoolTest() {
        cfg = new Configuration().configure("h2.hibernate.cfg.xml");
        sessionFactory = cfg.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @Test
    @Ignore
    public void delete() {
        session.beginTransaction();
        session.delete(session.get(School.class, new Long(1)));
        session.getTransaction().commit();

    }

    @Test
    @Ignore
    public void getSchoolTest() {
        // Matematik dersini saat 1 de 2 a sınıfında veren öğretmen
        List<Program> programs = session.createCriteria(Program.class).list();
        for (Program program : programs) {
            List<ProgramHour> hours = program.getProgramHours();
            for (ProgramHour hour : hours) {
                List<ProgramTeacher> programTeachers = hour.getProgramTeachers();
                for (ProgramTeacher programTeacher : programTeachers) {
                    System.err.println(hour.getHour().getName());
                    System.err.println(programTeacher.getTeacher().getName());
                    System.err.println(programTeacher.getProgramLesson().getLesson().getName());
                    System.err.println(programTeacher.getProgramLesson().getProgramClassRoom().getClassRoom().getName());
                }
            }
        }
    }

    @Test
    @Ignore
    public void addnewLessonOneHour() {
        ProgramHour pazartesi_13 = session.get(ProgramHour.class, new Long(1));
        Lesson fizik = session.get(Lesson.class, new Long(2));
        Teacher teacher = session.get(Teacher.class, new Long(1));
        ClassRoom classRoom = session.get(ClassRoom.class, new Long(3));
        entities.Class _1a = new entities.Class();

        ProgramLesson programLesson = new ProgramLesson();
        programLesson.setLesson(fizik);

        ProgramTeacher programTeacher = new ProgramTeacher();
        programTeacher.setTeacher(teacher);

        ProgramClassRoom programClassRoom = new ProgramClassRoom();
        programClassRoom.setClassRoom(classRoom);

        programLesson.setProgramClassRoom(programClassRoom);
        programTeacher.setProgramLesson(programLesson);

        ProgramClass programClass = new ProgramClass();
        programClass.setClass1(_1a);

        programClassRoom.setProgramClass(programClass);

        List<ProgramTeacher> programteachers = pazartesi_13.getProgramTeachers();
        programteachers.add(programTeacher);
        pazartesi_13.setProgramTeachers(programteachers);

        session.beginTransaction();

        session.save(programLesson);
        session.save(programTeacher);
        session.save(programClassRoom);
        session.save(_1a);
        session.save(programClass);

        session.update(pazartesi_13);

        session.getTransaction().commit();

    }

    @Test
    @Ignore
    public void testSchool() {

        School karalise = new School();
        karalise.setName("Kara Lise");

        Lesson matematik = new Lesson();
        matematik.setName("Matematik");

        Lesson fizik = new Lesson();
        fizik.setName("Fizik");

        Hour pazartesi_13 = new Hour();
        pazartesi_13.setName("Pazartesi 13:00");

        Hour sali_15 = new Hour();
        sali_15.setName("Salı 15:00");

        ClassRoom _1c = new ClassRoom();
        _1c.setName("1 C Sinifi");

        ClassRoom _2a = new ClassRoom();
        _2a.setName("2 A Sinifi");

        ClassRoom _3f = new ClassRoom();
        _3f.setName("3 F Sinifi");

        Teacher abdullah = new Teacher();
        abdullah.setName("Abdullah Gurlek");

        Teacher selim = new Teacher();
        selim.setName("Selim selimce");

        Teacher arzu = new Teacher();
        arzu.setName("Arzu kocabaş");

        Teacher mehmet = new Teacher();
        mehmet.setName("Mehmet Kara");

        Lesson cografya = new Lesson();
        cografya.setName("Cografya");

        Lesson turkce = new Lesson();
        turkce.setName("Türkçe");

        Lesson ingilizce = new Lesson();
        ingilizce.setName("Ingilizce");

        Program program = new Program();
        program.setName("xxx");
        ProgramTeacher mehmetProgram = new ProgramTeacher();
        mehmetProgram.setTeacher(mehmet);

        ProgramLesson matematikLesson = new ProgramLesson();
        matematikLesson.setLesson(matematik);

        ProgramClassRoom _2aProgram = new ProgramClassRoom();
        _2aProgram.setClassRoom(_2a);

        ProgramHour pazartesiProgramHour = new ProgramHour();
        pazartesiProgramHour.setProgramTeachers(Arrays.asList(mehmetProgram));
        pazartesiProgramHour.setHour(pazartesi_13);

        program.setProgramHours(Arrays.asList(pazartesiProgramHour));

        mehmetProgram.setProgramLesson(matematikLesson);
        matematikLesson.setProgramClassRoom(_2aProgram);

        session.beginTransaction();
        session.save(pazartesiProgramHour);
        session.save(program);
        session.save(mehmetProgram);
        session.save(matematikLesson);
        session.save(_2aProgram);

        session.save(_1c);

        session.save(_2a);
        session.save(_3f);

        session.save(abdullah);
        session.save(selim);
        session.save(arzu);
        session.save(mehmet);

        session.save(karalise);

        session.save(matematik);
        session.save(fizik);
        session.save(cografya);
        session.save(turkce);
        session.save(ingilizce);

        session.save(pazartesi_13);
        session.save(sali_15);
        session.getTransaction().commit();

    }

    @After
    public void tearDown() {
        session.close();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
