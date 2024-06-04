package com.frenzo.course.module.toc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenzo.Exception.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class TableOfContentsService {
    @Autowired
    TableOfContentsRepo tocRepo;

    public List<TableOfContents> getTableOfContents() {
        List<TableOfContents> tocs = tocRepo.findAll();
        if (!tocs.isEmpty()) {
            return tocs;
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public TableOfContents addTableOfContents(TableOfContents toc) {
        return tocRepo.save(toc);
    }

    public void deleteTableOfContents(int id) {
        tocRepo.deleteById(id);
    }

    public TableOfContents getTableOfContentsById(int id) {
        Optional<TableOfContents> toc = tocRepo.findById(id);
        if (toc.isPresent()) {
            return toc.get();
        } else {
            throw new NotFoundException("No records found");
        }
    }

    public TableOfContents updateTableOfContents(int id, TableOfContents updatedToc) {
        return tocRepo.findById(id).map(existingToc -> {
            updatedToc.setId(existingToc.getId());
            return tocRepo.save(updatedToc);
        }).orElseThrow(() -> new RuntimeException("Table of Contents with ID " + id + " not found"));
    }
}