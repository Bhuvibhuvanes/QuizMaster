package com.frenzo.course.module.toc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.frenzo.Exception.NotFoundException;

import java.util.List;

@RestController
@RequestMapping("/table-of-contents")
public class TableOfContentsController {
    @Autowired
    TableOfContentsService tocService;

    @PostMapping
    public ResponseEntity<TableOfContents> addTableOfContents(@RequestBody TableOfContents toc) {
        TableOfContents addedToc = tocService.addTableOfContents(toc);
        return new ResponseEntity<>(addedToc, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TableOfContents>> getTableOfContents() {
        List<TableOfContents> tocs = tocService.getTableOfContents();
        return new ResponseEntity<>(tocs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableOfContents> getTableOfContentsById(@PathVariable("id") int id) {
        TableOfContents toc = tocService.getTableOfContentsById(id);
        return new ResponseEntity<>(toc, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TableOfContents> updateTableOfContents(@PathVariable int id, @RequestBody TableOfContents toc) {
        TableOfContents updatedToc = tocService.updateTableOfContents(id, toc);
        return new ResponseEntity<>(updatedToc, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteTableOfContents(@PathVariable int id) throws NotFoundException {
        tocService.deleteTableOfContents(id);
        return HttpStatus.OK;
    }
}