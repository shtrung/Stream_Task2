package org.example;

import java.util.Map;

record Student(String name, Map<String, Integer> grades) {
}
