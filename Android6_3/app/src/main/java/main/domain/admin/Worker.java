package main.domain.admin;

import java.io.Serializable;

/**
 * Created by Anita on 2016/04/16.
 */
public class Worker implements Serializable {
    private long id;
    private String name;
    private String surname;
    private String address;


    private Worker()
    {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public Worker(Builder builder)
    {

        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
    }

    public static class Builder {
        private long id;
        private String name;
        private String surname;
        private String address;


        public Builder id(long id)
        {
            this.id = id;
            return this;
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }


        public Builder surname(String surname)
        {
            this.surname = surname;
            return this;
        }


        public Builder address(String address)
        {
            this.address = address;
            return this;
        }


        public Builder copy(Worker value) {
            this.id = value.id;
            this.name = value.name;
            this.surname = value.surname;
            this.address = value.address;
            return this;
        }


        public Worker build()
        {
            return new Worker(this);
        }
    }



}
