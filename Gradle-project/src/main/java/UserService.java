import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public EntityManager em = Persistence.createEntityManagerFactory("QA_EDU_V_FED").createEntityManager();

    public User add(User user){
        em.getTransaction().begin();
        User userFromDB = em.merge(user);
        em.getTransaction().commit();
        return userFromDB;
    }

    public User getUserById(int id){
        return em.find(User.class, id);
    }

    public List<User> getUsersByName(String userName) {
        List<User> allUsers = getAll();
        return allUsers.stream()
                .filter(u -> u.getName().equals(userName))
                .collect(Collectors.toList());
    }

    public User update(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        return getUserById(user.getUserId());
    }

    public List<User> getAll(){
        TypedQuery<User> namedQuery = em.createNamedQuery("User.getAll", User.class);
        return namedQuery.getResultList();
    }
}