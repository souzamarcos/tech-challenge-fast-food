package com.fiap.burger.entity.client;

import com.fiap.burger.entity.common.BaseEntity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Client extends BaseEntity {

    private String cpf;
    private String email;
    private String name;

    public Client(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client client)) return false;
        return Objects.equals(hashCode(), client.hashCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            getId(),
            getCpf(),
            getEmail(),
            getName(),
            getCreatedAt(),
            getModifiedAt(),
            getDeletedAt()
        );
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public Client(Long id, String cpf, String email, String name) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }

    public Client(String cpf, String email, String name) {
        this.cpf = cpf;
        this.email = email;
        this.name = name;
    }

    public Client(
        Long id,
        String cpf,
        String email,
        String name,
        LocalDateTime createdAt,
        LocalDateTime modifiedAt,
        LocalDateTime deletedAt
    ) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    @Override
    public String toString() {
        return "Client{" +
            "cpf='" + cpf + '\'' +
            ", email='" + email + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
