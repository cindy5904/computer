package org.example;

import org.example.Entity.Computer;
import org.example.Entity.Peripherique;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class IhmPeripherique {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("computerJpa");
    EntityManager em = emf.createEntityManager();

    Scanner sc = new Scanner(System.in);


    public void start (){
        while (true){
            System.out.println("Menu : ");
            System.out.println("1/ cree un péripherque");
            System.out.println("2/ afficher tout");
            System.out.println("3/ afficher par id");
            System.out.println("4/ supprimer");
            System.out.println("5/ editer");
            System.out.println("6/ Créer un périphérique");
            int entry = sc.nextInt();
            sc.nextLine();
            switch (entry){
                case 1:
                    createPeripherique();
                    break;
                case 2:
                    getAllPeripherique();
                    break;
                case 3:
                    getPeripheriqueById();
                    break;
                case 4:
                    deletePeripherique();
                    break;
                case 5:
                    updatePeripherique();
                    break;
                default:
                    return;
            }
        }

    }
    private void createPeripherique () {
        Peripherique peripherique = Peripherique.builder()
                .name("Peripherique")
                .description("Un peripherique ")
                .computers(new ArrayList<>())
                .build();
        peripherique.add(em.find(Computer.class, 2));
        peripherique.add(em.find(Computer.class, 3));
        peripherique.add(em.find(Computer.class, 4));

        em.getTransaction().begin();
        em.persist(peripherique);
        em.getTransaction().commit();
    }

    private void getAllPeripherique () {
        Query query = em.createQuery("select c from Peripherique c");
        List PeripheriqueList = query.getResultList();
        for (Object peripherique : PeripheriqueList){
            System.out.println(peripherique);
        }

    }
    private Peripherique getPeripheriqueById () {
        System.out.println("id peripherique :");
        int id = sc.nextInt();
        sc.nextLine();

        Peripherique peripherique = em.find(Peripherique.class,id);
        if(peripherique != null){
            System.out.println(peripherique);
        }else {
            System.out.println("Peripherique not found");
        }
        return peripherique;
    }

    private void deletePeripherique () {
        Peripherique peripherique = getPeripheriqueById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(peripherique != null){
            em.remove(peripherique);
        }
        transaction.commit();
    }

    private void updatePeripherique () {
        Peripherique peripherique = getPeripheriqueById();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        if(peripherique != null){
            peripherique.setName("peripherique2");
            peripherique.setDescription("description2");
        }
        transaction.commit();
    }


}
