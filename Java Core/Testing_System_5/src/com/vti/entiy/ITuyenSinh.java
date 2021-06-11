package com.vti.entiy;

import java.util.List;

public interface ITuyenSinh {
    public void add_candidates(List<Student> students);

    public void show_list_candidates(List<Student> students);

    public void find_by_Sbd(List<Student> students);

}
