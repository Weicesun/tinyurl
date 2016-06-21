from django.conf.urls import url, include
from . import views
urlpatterns = [
    url(r'^$',views.index, name='home'),
    url(r'^(?P&lt;short_id&gt;\w{6})$',views.redirect_original, name='redirectoriginal'),
    url(r'^makeshort/$', views.short_url, name='shortenurl'),
]
