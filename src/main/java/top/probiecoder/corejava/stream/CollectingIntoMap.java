package top.probiecoder.corejava.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingIntoMap {
    @Data
    @AllArgsConstructor
    public static class Person {
        private int id;
        private String name;

        @Override
        public String toString() {
            return getClass().getName() + "[id = " + id + ", name = " + name + "]";
        }
    }

    public static Stream<Person> people() {
        return Stream.of(new Person(1001, "Perter"),
                new Person(1002, "Paul"),
                new Person(1003, "Mary"));
    }

    public static void main(String[] args) {
        Map<Integer, String> idToName = people().collect(
                Collectors.toMap(Person::getId, Person::getName)
        );
        System.out.println(idToName);

        Map<Integer, Person> idToPerson = people().collect(
                Collectors.toMap(Person::getId, Function.identity())
        );
        System.out.println(idToPerson);
        idToPerson = people().collect(
                Collectors.toMap(Person::getId, Function.identity(),(existingValue, newValue) -> {
                    throw new IllegalStateException();
                }, TreeMap::new)
        );
        System.out.println(idToPerson);
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
//        Map<String, String> languageNames = locales.collect(
//                Collectors.toMap(Locale::getDisplayLanguage, l -> l.getDisplayLanguage(l),
//                        (existingValue, newValue) -> existingValue)
//        );
//        System.out.println(languageNames);

       /* Map<String, List<Locale>> countryToLocale = locales.collect(
                Collectors.groupingBy(Locale::getCountry)
        );
        System.out.println(countryToLocale.get("CN"));*/

       Map<Boolean, List<Locale>> englishAndOtherLocales = locales.collect(
               Collectors.partitioningBy(l -> l.getLanguage().equals("zh"))
       );
        System.out.println(englishAndOtherLocales.get(true));
    }
}
