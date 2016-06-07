from __future__ import unicode_literals

from django.db import models

# Create your models here.
class Table(models.Model):
    Long_url = models.CharField(max_length=30)
    Short_url = models.CharField(max_length=30)

