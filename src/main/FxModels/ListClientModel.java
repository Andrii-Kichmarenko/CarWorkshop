package FxModels;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import models.Client;
import org.omg.CORBA.portable.ApplicationException;
import utils.ExtensionUtility;
import utils.converters.ConverterClient;

import java.util.ArrayList;
import java.util.List;

public class ListClientModel {
    private ObservableList<ClientFx> clientFxObservableList = FXCollections.observableArrayList();
//    private ObservableList<AuthorFx> authorFxObservableList = FXCollections.observableArrayList();
//    private ObservableList<CategoryFx> categoryFxObservableList = FXCollections.observableArrayList();
//
//    private ObjectProperty<AuthorFx> authorFxObjectProperty = new SimpleObjectProperty<>();
//    private ObjectProperty<CategoryFx> categoryFxObjectProperty = new SimpleObjectProperty<>();

    private List<ClientFx> clientFxList = new ArrayList<>();

    public void init() throws ApplicationException {
        Class instance = Client.class;
        List<Client> clients = ExtensionUtility.getExtension(instance);
        clientFxList.clear();
        clients.forEach(client -> {
            this.clientFxList.add(ConverterClient.convertToClientFx(client));
        });
        this.clientFxObservableList.setAll(clientFxList);

 //       initAuthors();
 //       initCategory();
    }

    public ObservableList<ClientFx> getClientFxObservableList() {
        return clientFxObservableList;
    }

    public void setBookFxObservableList(ObservableList<ClientFx> clientFxObservableList) {
        this.clientFxObservableList = clientFxObservableList;
    }
/*    public void filterBooksList() {
        if (getAuthorFxObjectProperty() != null && getCategoryFxObjectProperty() != null) {
            filterPredicate(predicateAuthor().and(predicateCatgory()));
        } else if (getCategoryFxObjectProperty() != null) {
            filterPredicate(predicateCatgory());
        } else if (getAuthorFxObjectProperty() != null) {
            filterPredicate(predicateAuthor());
        } else {
            this.bookFxObservableList.setAll(this.bookFxList);
        }
    }

    private void initAuthors() throws ApplicationException {
        AuthorDao authorDao = new AuthorDao();
        List<Author> authorList = authorDao.queryForAll(Author.class);
        this.authorFxObservableList.clear();
        authorList.forEach(author -> {
            AuthorFx authorFx = ConverterAuthor.convertToAuthorFx(author);
            this.authorFxObservableList.add(authorFx);
        });
    }

    private void initCategory() throws ApplicationException {
        CategoryDao categoryDao = new CategoryDao();
        List<Category> categories = categoryDao.queryForAll(Category.class);
        this.categoryFxObservableList.clear();
        categories.forEach(c -> {
            CategoryFx categoryFx = ConverterCategory.convertToCategoryFx(c);
            this.categoryFxObservableList.add(categoryFx);
        });
    }

    private Predicate<BookFx> predicateCatgory() {
        return bookFx -> bookFx.getCategoryFx().getId() == getCategoryFxObjectProperty().getId();
    }

    private Predicate<BookFx> predicateAuthor() {
        return bookFx -> bookFx.getAuthorFx().getId() == getAuthorFxObjectProperty().getId();
    }

    private void filterPredicate(Predicate<BookFx> predicate) {
        List<BookFx> newList = bookFxList.stream().filter(predicate).collect(Collectors.toList());
        this.bookFxObservableList.setAll(newList);
    }

    public ObservableList<BookFx> getBookFxObservableList() {
        return bookFxObservableList;
    }

    public void setBookFxObservableList(ObservableList<BookFx> bookFxObservableList) {
        this.bookFxObservableList = bookFxObservableList;
    }

    public ObservableList<AuthorFx> getAuthorFxObservableList() {
        return authorFxObservableList;
    }

    public void setAuthorFxObservableList(ObservableList<AuthorFx> authorFxObservableList) {
        this.authorFxObservableList = authorFxObservableList;
    }

    public ObservableList<CategoryFx> getCategoryFxObservableList() {
        return categoryFxObservableList;
    }

    public void setCategoryFxObservableList(ObservableList<CategoryFx> categoryFxObservableList) {
        this.categoryFxObservableList = categoryFxObservableList;
    }

    public AuthorFx getAuthorFxObjectProperty() {
        return authorFxObjectProperty.get();
    }

    public ObjectProperty<AuthorFx> authorFxObjectPropertyProperty() {
        return authorFxObjectProperty;
    }

    public void setAuthorFxObjectProperty(AuthorFx authorFxObjectProperty) {
        this.authorFxObjectProperty.set(authorFxObjectProperty);
    }

    public CategoryFx getCategoryFxObjectProperty() {
        return categoryFxObjectProperty.get();
    }

    public ObjectProperty<CategoryFx> categoryFxObjectPropertyProperty() {
        return categoryFxObjectProperty;
    }

    public void setCategoryFxObjectProperty(CategoryFx categoryFxObjectProperty) {
        this.categoryFxObjectProperty.set(categoryFxObjectProperty);
    }
    */
}
