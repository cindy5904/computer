package org.example;

import org.example.Entity.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IHM {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("computerJpa");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);
    private IhmPeripherique ihmPeripherique;
    public IHM() {
        this.ihmPeripherique = new IhmPeripherique();
    }

    public void start (){
        while (true){
            System.out.println("Menu : ");
            System.out.println("1/ cree");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            System.out.println("5/ editer");
            System.out.println("6/ Menu Peripherique");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    createComputer();
                    break;
                case 2:
                    getAllComputer();
                    break;
                case 3:
                    getComputerById();
                    break;
                case 4:
                    deleteComputer();
                    break;
                case 5:
                    editComputer();
                    break;
                case 6:
                    ihmPeripherique.start();
                    break;
                default:
                    return;
            }
        }

    }

    private void createComputer (){

        Peripherique peripherique = Peripherique.builder()
                .name("Peripherique")
                .description("Un peripherique ")
                .build();

        Processeur processeur = Processeur.builder()
                .type("type")
                .nbCoeur(4)
                .build();


        SystemExplorer systemExplorer1 = SystemExplorer.builder()
                .name("Système 1")
                .build();

        Identification identification = Identification.builder()
                .addressImac("00:1A:2B:3C:4D:5E")
                .addressIp("192.168.0.1")
                .build();

        Computer computer = Computer.builder()
                .name("MyComputer")
                .price(1200.50f)
                .identification(identification)
                .processeur(processeur)
                .systemExplorers(systemExplorer1)
                .peripheriques(new ArrayList<>())
                .build();


        em.getTransaction().begin();
        em.persist(processeur);
        em.persist(systemExplorer1);
        em.persist(peripherique);
        em.persist(computer);
        em.getTransaction().commit();
    }

    private void getAllComputer (){
        Query query = em.createQuery("select c from Computer c");
        List computerList = query.getResultList();

        for (Object computer : computerList){
            System.out.println(computer);
        }
    }

    private Computer getComputerById (){
        System.out.println("id computer :");
        int id = sc.nextInt();
        sc.nextLine();

        Computer computer = em.find(Computer.class,id);
        if(computer != null){
            System.out.println(computer);
        }else {
            System.out.println("Computer not found");
        }
        return computer;
    }

    private void deleteComputer (){
        Computer computer = getComputerById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(computer != null){
            em.remove(computer);
        }
        transaction.commit();
    }

    private void editComputer (){
        Computer computer = getComputerById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(computer != null){
            computer.setName("myComputer2");
            computer.setPrice(1000.99f);
        }
        transaction.commit();
    }

    private void CreateComputer () {

    }
}
