package ch.bbcag.jakarta.ttbank.model;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity(name = "money_account")
public class MoneyAccount {

	@Id
	@NotBlank(message = "id_cannot_be_blank")
	@NotNull(message = "id_cannot_be_null")
	private String id;

	@ManyToOne
	@JsonbTransient
	@JoinColumn(name = "user_email")
	private User user;

	@NotBlank(message = "name_cannot_be_blank")
	@NotNull(message = "name_cannot_be_null")
	private String name;

	@NotBlank(message = "balance_cannot_be_blank")
	@NotNull(message = "balance_cannot_be_null")
	private float balance;

	@OneToMany(mappedBy = "senderAccountId")
	private Set<Transaction> transactionsSend;

	@OneToMany(mappedBy = "receiverAccountId")
	private Set<Transaction> transactionsReceive;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public Set<Transaction> getTransactionsSend() {
		return transactionsSend;
	}

	public void setTransactionsSend(Set<Transaction> transactionsSend) {
		this.transactionsSend = transactionsSend;
	}

	public Set<Transaction> getTransactionsReceive() {
		return transactionsReceive;
	}

	public void setTransactionsReceive(Set<Transaction> transactionsReceive) {
		this.transactionsReceive = transactionsReceive;
	}
}
