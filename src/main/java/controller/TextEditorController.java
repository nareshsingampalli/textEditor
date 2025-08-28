package controller;

//TextEditorController.java

import service.TextEditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/editor")
@CrossOrigin(origins = "*")
public class TextEditorController {

 @Autowired
 private TextEditorService textEditorService;

 @GetMapping("/content")
 public ResponseEntity<String> getContent() {
     return ResponseEntity.ok(textEditorService.getContent());
 }

 @PostMapping("/write")
 public ResponseEntity<String> writeText(@RequestBody String text) {
	 textEditorService.write(text);
     textEditorService.saveState();
     return ResponseEntity.ok(textEditorService.getContent());
 }


 // NEW: Endpoint for complete content replacement
 @PostMapping("/set-content")
 public ResponseEntity<String> setContent(@RequestBody String content) {
     textEditorService.setContent(content);
     textEditorService.saveState();
     return ResponseEntity.ok(textEditorService.getContent());
 }

 // NEW: Endpoint for incremental text addition
 @PostMapping("/append-text")
 public ResponseEntity<String> appendText(@RequestBody String text) {
     textEditorService.appendText(text);
     textEditorService.saveState();
     return ResponseEntity.ok(textEditorService.getContent());
 }
 @PostMapping("/undo")
 public ResponseEntity<String> undo() {
     String content = textEditorService.undo();
     return ResponseEntity.ok(content);
 }

 @PostMapping("/redo")
 public ResponseEntity<String> redo() {
     String content = textEditorService.redo();
     return ResponseEntity.ok(content);
 }

 @GetMapping("/can-undo")
 public ResponseEntity<Boolean> canUndo() {
     return ResponseEntity.ok(textEditorService.canUndo());
 }

 @GetMapping("/can-redo")
 public ResponseEntity<Boolean> canRedo() {
     return ResponseEntity.ok(textEditorService.canRedo());
 }

 @PostMapping("/clear")
 public ResponseEntity<String> clear() {
     textEditorService.clear();
     return ResponseEntity.ok("Editor cleared");
 }
}