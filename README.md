# Projet Démo JPA

Ce projet contient 3 démonstrations :

- Le chargement d'une collection LAZY ou EAGER
- La relation Many-to-Many avec une table intermédiaire contenant des champs supplémentaires
  (avec clé composite)
- La relation Many-to-Many avec une table intermédiaire contenant des champs supplémentaires
  (sans clé composite)

## Dépendences

- Tomcat 10 (>= 10.0.27) (non inclus)
- JakartaEE 9
- JSTL

##

- JPA Jakarta
- Hibernate ORM 6.1.5.Final

## 3x Database MYSQL requises (Voir persistence.xml)

- jpa_example1_composite
- jpa_example2_withcomposite
- jpa_example2_withoutcomposite
- jpa_example3_lazy_eager

## 1# Démo chargement d'une collection en Lazy ou Eager (Eager n'est pas recommandé)

**Disponible dans le package lazy_eager:**

```java
@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
private List<Book> bookList=new ArrayList<>();
```

**Chargement grâce au JOIN FETCH dans la requête JPQL :**

```java
TypedQuery<Author> query=em.createQuery("SELECT a FROM Author a JOIN FETCH a.bookList WHERE a.id=:id",Author.class);
        query.setParameter("id",1L);
        Author author=query.getSingleResult();
```

## 2# Démo Relation Many to many avec clé composite

Disponible dans le package **manymany.example1** et **manymany.example2.withcomposite**

## 3# Démo Relation Many to many sans clé composite

Disponible dans le package **manymany.example2.withoutcomposite**

