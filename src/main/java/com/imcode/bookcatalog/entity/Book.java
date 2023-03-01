package com.imcode.bookcatalog.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.List;

@Data
@Entity
@Table(name = "book")
public class Book extends AbstractBaseEntity {

	@Serial
	private static final long serialVersionUID = 682594603427164426L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "publisher_id", nullable = false)
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name = "book_author",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "author_id", referencedColumnName = "id")}
	)
	private List<Author> authors;

	@ManyToMany
	@JoinTable(name = "book_category",
			joinColumns = {@JoinColumn(name = "book_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "category_id", referencedColumnName = "code")}
	)
	private List<Category> categories;
}
