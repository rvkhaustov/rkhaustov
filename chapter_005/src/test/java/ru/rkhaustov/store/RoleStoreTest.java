package ru.rkhaustov.store;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by rvkha_000 on 30.05.2017.
 */
public class RoleStoreTest {
    /**
     * test Add.
     */
    @Test
    public void  whenAddRoleThenCorrectAdd() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role();

        role.setId("1001");
        roleStore.add(role);

        assertThat(roleStore.getSimpleArray().get(0).getId(), is("1001"));
    }
    /**
     * test delete.
     */
    @Test
    public void  whenDeleteRoleThenCorrectDelete() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role();

        role.setId("1001");
        roleStore.add(role);
        role.setId("1002");
        roleStore.add(role);

        roleStore.delete("1001");

        assertThat(roleStore.getSimpleArray().get(0).getId(), is("1002"));
    }
  /**
     * test update.
     */
    @Test
    public void  whenUpdateRoleThenCorrectUpdate() {
        RoleStore roleStore = new RoleStore();
        Role role = new Role();

        role.setId("1001");
        roleStore.add(role);

        Role roleSecond = new Role();
        roleSecond.setId("1002");

        roleStore.update(roleSecond, "1001");

        assertThat(roleStore.getSimpleArray().get(0).getId(), is("1002"));
    }
}