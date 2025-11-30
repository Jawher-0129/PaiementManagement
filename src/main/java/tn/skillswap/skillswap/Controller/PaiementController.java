package tn.skillswap.skillswap.Controller;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import tn.skillswap.skillswap.Entity.Paiement;
import tn.skillswap.skillswap.Interface.IPaiementService;
import tn.skillswap.skillswap.Service.EmailService;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/paiement")
@CrossOrigin(origins = "http://localhost:4200")
public class PaiementController {
    @Autowired
    private IPaiementService paiementService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/add")
    public Paiement addPaiement(@RequestBody Paiement paiement) {
        paiement.setDate(LocalDateTime.now());
        if (paiement.getUser() != null && paiement.getUser().getEmail() != null) {
            String to = paiement.getUser().getEmail();
            String subject = "Confirmation de paiement";
            String text = "Votre paiement de " + paiement.getMontant() + " a été enregistré avec succès. Merci pour votre confiance !";
            emailService.sendPaymentConfirmationEmail(to, subject, text);
        }
        return paiementService.addPaiement(paiement);
    }
    @GetMapping("/all")
    public List<Paiement> getAllPaiements() {
        return paiementService.getAllPaiements();
    }

    @GetMapping("/get/{idPaiement}")
    public Paiement getPaiementById(@PathVariable long idPaiement) {
        return paiementService.getPaiementById(idPaiement);
    }

    @PutMapping("/update")
    public Paiement updatePaiement(@RequestBody Paiement paiement) {
        return paiementService.updatePaiement(paiement);
    }

    @DeleteMapping("/delete/{idPaiement}")
    public void deletePaiement(@PathVariable long idPaiement) {
        paiementService.deletePaiement(idPaiement);
    }

    @GetMapping("/pdf/facture/{id}")
    public ResponseEntity<byte[]> getFacturePaiement(@PathVariable Long id) {
        try {
            Paiement paiement = paiementService.getPaiementById(id);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, out);
            document.open();

            // Fonts
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Font subTitleFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font regularFont = new Font(Font.FontFamily.HELVETICA, 12);
            Font boldFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);

            // Title
            Paragraph title = new Paragraph("Facture de Paiement", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20f);
            document.add(title);

            // Company / Header Section
            document.add(new Paragraph("SkillSwap", boldFont));
            document.add(new Paragraph("Adresse: 123 Rue Principale, Tunis", regularFont));
            document.add(new Paragraph("Email: contact@skillswap.tn", regularFont));
            document.add(new Paragraph("Téléphone: +216 71 000 000", regularFont));
            document.add(Chunk.NEWLINE);

            // Client Info
            document.add(new Paragraph("Informations du Client", subTitleFont));
            document.add(new Paragraph("Name : " + paiement.getUser().getFirst_name() + " " + paiement.getUser().getLast_Name(), regularFont));
            document.add(new Paragraph("Email : " + paiement.getUser().getEmail(), regularFont));
            document.add(Chunk.NEWLINE);

            // Payment Info Table
            PdfPTable table = new PdfPTable(2);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Headers
            table.addCell(new PdfPCell(new Phrase("Détail", boldFont)));
            table.addCell(new PdfPCell(new Phrase("Valeur", boldFont)));

            // Data rows
            table.addCell("ID Paiement");
            table.addCell(String.valueOf(paiement.getIdPaiement()));

            table.addCell("Montant");
            table.addCell(paiement.getMontant() + " €");

            table.addCell("Mode de Paiement");
            table.addCell(paiement.getMode());

            table.addCell("Date de Paiement");
            table.addCell(String.valueOf(paiement.getDate()));

            document.add(table);

            Paragraph footer = new Paragraph("Merci pour votre confiance !", subTitleFont);
            footer.setAlignment(Element.ALIGN_CENTER);
            footer.setSpacingBefore(30f);
            document.add(footer);

            document.close();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "facture_" + paiement.getIdPaiement() + ".pdf");

            return new ResponseEntity<>(out.toByteArray(), headers, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/chatbot")
    public Map<String, String> chatbotResponse(@RequestBody Map<String, String> payload) {
        RestTemplate restTemplate = new RestTemplate();
        String flaskApiUrl = "http://localhost:5000/chat";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON); // Set Content-Type: application/json

        HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(flaskApiUrl, request, Map.class);
        return response.getBody();
    }












}

